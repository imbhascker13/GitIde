package com.mindtree.hospitalmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalmanage.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
