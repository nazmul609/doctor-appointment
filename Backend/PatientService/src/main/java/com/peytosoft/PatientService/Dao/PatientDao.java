package com.peytosoft.PatientService.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peytosoft.PatientService.Model.Patient;



@Repository
public interface PatientDao extends JpaRepository<Patient,Integer>{

	Optional<Patient> findById(Integer id);
	

}
