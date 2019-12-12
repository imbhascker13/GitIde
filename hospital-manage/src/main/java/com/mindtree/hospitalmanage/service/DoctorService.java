package com.mindtree.hospitalmanage.service;

import java.util.List;

import com.mindtree.hospitalmanage.dto.DoctorDto;
import com.mindtree.hospitalmanage.entity.Doctor;
import com.mindtree.hospitalmanage.exception.service.ServiceException;

public interface DoctorService {

	public List<DoctorDto> getAllDoctors() throws ServiceException;

	public List<DoctorDto> displayDoctors(int pc) throws ServiceException;

	public List<DoctorDto> getFile();

}
