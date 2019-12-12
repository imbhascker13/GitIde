package com.mindtree.hospitalmanage.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanage.dto.PatientDto;
import com.mindtree.hospitalmanage.entity.Doctor;
import com.mindtree.hospitalmanage.entity.Patient;
import com.mindtree.hospitalmanage.exception.service.ServiceException;
import com.mindtree.hospitalmanage.exceptionsutil.ErrorConstants;
import com.mindtree.hospitalmanage.repository.DoctorRepository;
import com.mindtree.hospitalmanage.repository.PatientRepository;
import com.mindtree.hospitalmanage.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	DoctorRepository doctorRepository;
	ModelMapper modelMapper=new ModelMapper();
	@Override
	public PatientDto assignPatient(String doctorName,String patientName) throws ServiceException {
		//Patient patient= convertDtoToEntity(patientDto);
		List<Doctor> doctors=doctorRepository.findAll();
		List<Patient> patients=patientRepository.findAll();
		Doctor doctor=new Doctor();
		Patient patient1= new Patient();
		
		for(Patient p: patients) {
			try {
			if(p.getPatientName().equalsIgnoreCase(patientName)) {
				patient1=p;
			}
			}
			catch (DataAccessException e) {
				throw new ServiceException(ErrorConstants.NOPATIENTFOUND);
			}
		}
		
		for(Doctor d: doctors) {
			try {
			if(d.getDoctorName().equalsIgnoreCase(doctorName)) {
				doctor=d;
			}
			}
			catch (DataAccessException e) {
				throw new ServiceException(ErrorConstants.NODOCTORFOUND);
			}
		}
		doctor.setSalary(doctor.getSalary()+patient1.getBillAmount());
		patient1.setDoctor(doctor);
		Patient newPatient= patientRepository.save(patient1);
		PatientDto patientDto2=convertEntityToDto(newPatient);
		return patientDto2;
	}
	private PatientDto convertEntityToDto(Patient newPatient) {
		// TODO Auto-generated method stub
		return modelMapper.map(newPatient,PatientDto.class);
	}
	private Patient convertDtoToEntity(PatientDto patientDto) {
		// TODO Auto-generated method stub
		return modelMapper.map(patientDto,Patient.class);
	}
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

}
