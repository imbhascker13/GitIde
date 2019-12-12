package com.mindtree.hospitalmanage.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="doctorId")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "doctorId")
public class Doctor implements Comparable<Doctor> {
	@Id
	private int doctorId;
	private String doctorName;
	private double experience;
	private double salary;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
	List<Patient> patients;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int doctorId, String doctorName, double experience, double salary, List<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.experience = experience;
		this.salary = salary;
		this.patients = patients;
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

	@JsonIgnore
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", experience=" + experience
				+ ", salary=" + salary + ", patients=" + patients + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(experience);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (Double.doubleToLongBits(experience) != Double.doubleToLongBits(other.experience))
			return false;
		return true;
	}

	@Override
	public int compareTo(Doctor d) {
		if (d.getExperience() == experience) {
			return 0;
		} else if (d.getExperience() > experience) {
			return 1;
		} else {
			return -1;
		}
	}

}
