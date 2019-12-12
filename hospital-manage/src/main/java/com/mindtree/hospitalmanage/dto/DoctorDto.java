package com.mindtree.hospitalmanage.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.hospitalmanage.entity.Patient;

public class DoctorDto {
	private int doctorId;
	private String doctorName;
	private double experience;
	private double salary;
	@JsonIgnoreProperties("doctorDto")
	private List<PatientDto> patientDtos;
	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorDto(int doctorId, String doctorName, double experience, double salary, List<PatientDto> patientDtos) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.experience = experience;
		this.salary = salary;
		this.patientDtos = patientDtos;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<PatientDto> getPatientDtos() {
		return patientDtos;
	}
	public void setPatientDtos(List<PatientDto> patientDtos) {
		this.patientDtos = patientDtos;
	}
	@Override
	public String toString() {
		return "DoctorDto [doctorId=" + doctorId + ", doctorName=" + doctorName + ", experience=" + experience
				+ ", salary=" + salary + ", patientDtos=" + patientDtos + "]";
	}
	
}
