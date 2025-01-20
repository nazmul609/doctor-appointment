package com.peytosoft.DoctorService.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peytosoft.DoctorService.Model.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor,Integer>{

	Optional<Doctor> findById(Integer id);

	Doctor findByFirstName(String firstName);

	Doctor findByLastName(String lastName);

	List<Doctor> findBySpeciality(String spec);

}
