package com.mindtree.hospitalmanage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
	@Id
	private int patientId;
	private String patientName;
	private double billAmount;
	@ManyToOne
	private Doctor doctor;
	public Patient() {
		super();
	}
	public Patient(int patientId, String patientName, double billAmount, Doctor doctor) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.billAmount = billAmount;
		this.doctor = doctor;
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
	//@JsonIgnore
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", billAmount=" + billAmount
				+ ", doctor=" + doctor + "]";
	}
	
}
