package com.mindtree.hospitalmanage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PatientDto {
	private int patientId;
	private String patientName;
	private double billAmount;
	@JsonIgnoreProperties("patientDtos")
	private DoctorDto doctorDto;
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDto(int patientId, String patientName, double billAmount, DoctorDto doctorDto) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.billAmount = billAmount;
		this.doctorDto = doctorDto;
	}
	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName=" + patientName + ", billAmount=" + billAmount
				+ ", doctorDto=" + doctorDto + "]";
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public DoctorDto getDoctorDto() {
		return doctorDto;
	}
	public void setDoctorDto(DoctorDto doctorDto) {
		this.doctorDto = doctorDto;
	}
	
}
