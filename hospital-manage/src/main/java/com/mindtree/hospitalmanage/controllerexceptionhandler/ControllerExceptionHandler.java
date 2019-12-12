package com.mindtree.hospitalmanage.controllerexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.hospitalmanage.controller.DoctorController;
import com.mindtree.hospitalmanage.controller.PatientController;
import com.mindtree.hospitalmanage.dto.ExceptionDto;
import com.mindtree.hospitalmanage.exception.service.ServiceException;

@RestControllerAdvice(assignableTypes= {DoctorController.class,PatientController.class})
public class ControllerExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionDto> serviceExceptionHandler(Exception e, Throwable cause){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
	}
}
