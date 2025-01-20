package com.peytosoft.DoctorService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.peytosoft.DoctorService.Dao.DoctorDao;
import com.peytosoft.DoctorService.Model.Doctor;

@Service
public class DoctorService {
	
	@Autowired
	DoctorDao doctorDao;

	public ResponseEntity<String> addDoctor(Doctor doctor) {
		doctorDao.save(doctor);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<Optional<Doctor>> getDoctorBydoctorId(Integer id) {
		try {
            return new ResponseEntity<>(doctorDao.findById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Doctor> getDoctorByfirstName(String firstName) {
		try {
            return new ResponseEntity<>(doctorDao.findByFirstName(firstName), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Doctor> getDoctorBylastName(String lastName) {
		try {
            return new ResponseEntity<>(doctorDao.findByLastName(lastName), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Doctor>> getDoctorByspeciality(String spec) {
		try {
            return new ResponseEntity<>(doctorDao.findBySpeciality(spec), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Doctor>> getAllDoctor() {
		try {
            return new ResponseEntity<>(doctorDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateProfile(Doctor doctor) {
		Doctor existingDoctor = doctorDao.findById(doctor.getId() ).orElse(null);
		existingDoctor.setFirstName(doctor.getFirstName());
		existingDoctor.setLastName(doctor.getLastName());
		existingDoctor.setDepartment(doctor.getDepartment());
		existingDoctor.setSpeciality(doctor.getSpeciality());
		existingDoctor.setContactNo(doctor.getContactNo());
		existingDoctor.setDesignation(doctor.getDesignation());
		doctorDao.save(existingDoctor);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	
	

}
