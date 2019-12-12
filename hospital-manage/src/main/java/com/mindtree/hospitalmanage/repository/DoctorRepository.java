package com.mindtree.hospitalmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalmanage.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
