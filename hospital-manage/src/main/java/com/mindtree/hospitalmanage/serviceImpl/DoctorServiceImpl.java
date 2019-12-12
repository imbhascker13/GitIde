package com.mindtree.hospitalmanage.serviceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanage.dto.DoctorDto;
import com.mindtree.hospitalmanage.entity.Doctor;
import com.mindtree.hospitalmanage.exception.service.ServiceException;
import com.mindtree.hospitalmanage.exceptionsutil.ErrorConstants;
import com.mindtree.hospitalmanage.repository.DoctorRepository;
import com.mindtree.hospitalmanage.repository.PatientRepository;
import com.mindtree.hospitalmanage.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<DoctorDto> getAllDoctors() throws ServiceException {
		List<Doctor> newDoctors = new ArrayList<Doctor>();
		try {
			List<Doctor> doctors = doctorRepository.findAll();
			for (Doctor doctor1 : doctors) {
				Doctor newDoctor = new Doctor();
				newDoctor.setDoctorId(doctor1.getDoctorId());
				newDoctor.setDoctorName(doctor1.getDoctorName());
				newDoctor.setExperience(doctor1.getExperience());
				newDoctor.setSalary(doctor1.getSalary());
				newDoctor.setPatients(doctor1.getPatients());
				newDoctors.add(newDoctor);
				Collections.sort(newDoctors);

			}
		} catch (DataAccessException e) {
			throw new ServiceException(ErrorConstants.NODOCTORFOUND);
		}
		return newDoctors.stream().map(e -> convertEntityToDto(e)).collect(Collectors.toList());
	}

	private DoctorDto convertEntityToDto(List<Doctor> doctors) {
		return modelMapper.map(doctors, DoctorDto.class);
	}

	private Doctor convertDtoToEntity(DoctorDto doctorDto) {
		return modelMapper.map(doctorDto, Doctor.class);
	}

	@Override
	public List<DoctorDto> displayDoctors(int pc) throws ServiceException {
		List<Doctor> doctors = doctorRepository.findAll();
		List<Doctor> newDoctors = new ArrayList<Doctor>();
		if(pc==0) {
			throw new ServiceException(ErrorConstants.NOPATIENTFOUND);
		
		}else {
			newDoctors = doctors.stream().filter(e -> e.getPatients().size() > pc).collect(Collectors.toList());
		}
		return newDoctors.stream().map(e -> convertEntityToDto(e)).collect(Collectors.toList());

	}

	private DoctorDto convertEntityToDto(Doctor e) {
		return modelMapper.map(e, DoctorDto.class);
	}

	@Override
	public List<DoctorDto> getFile() {
		List<Doctor>doctors=doctorRepository.findAll();
		try {
			File file = new File("D:\\bhaskar\\Hospital.txt");
			file.createNewFile();
			FileWriter fout = new FileWriter(file);
			for (Doctor d: doctors) {
				fout.write(""+d);
				fout.write("/n");
			}
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doctors.stream().map(e -> convertEntityToDto(e)).collect(Collectors.toList());
	}
}
