package com.mindtree.hospitalmanage.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hospitalmanage.dto.DoctorDto;
import com.mindtree.hospitalmanage.entity.Doctor;
import com.mindtree.hospitalmanage.exception.service.ServiceException;
import com.mindtree.hospitalmanage.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@GetMapping(value = "/doctor")
	public ResponseEntity<List<DoctorDto>> getAllDoctors() throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllDoctors());
	}

	@GetMapping(value = "/doctors")
	public ResponseEntity<List<DoctorDto>> displayDoctors(@RequestParam int pc) throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(doctorService.displayDoctors(pc));
	}

//	public String addFile(List<Doctor> res) {
//		String message = "";
//		try {
//			File file = new File("D:\\bhaskar\\Hospital.txt");
//			file.createNewFile();
//			FileWriter fout = new FileWriter(file);
//			fout.write(res.toString());
//			fout.close();
//			message = "succesfully saved file";
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return message;
//	}
	@GetMapping(value = "/fileio")
	public List<DoctorDto>getFile(){
		return doctorService.getFile();
	}
}
