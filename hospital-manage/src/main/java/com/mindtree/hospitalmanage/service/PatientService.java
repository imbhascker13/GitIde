package com.mindtree.hospitalmanage.service;

import java.util.List;

import com.mindtree.hospitalmanage.dto.PatientDto;
import com.mindtree.hospitalmanage.entity.Patient;
import com.mindtree.hospitalmanage.exception.service.ServiceException;

public interface PatientService {

	public PatientDto assignPatient(String doctorName,String patientName) throws ServiceException;

	public List<Patient> getAllPatients();

}
