package com.peytosoft.PatientService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.peytosoft.PatientService.Dao.PatientDao;
import com.peytosoft.PatientService.Model.Patient;




@Service
public class PatientService {
	
	@Autowired
	PatientDao patientDao;

	public ResponseEntity<List<Patient>> getAllPatient() {
		try {
            return new ResponseEntity<>(patientDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Optional<Patient>> getpatientBypatientId(Integer id) {
		try {
            return new ResponseEntity<>(patientDao.findById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> createPatient(Patient patient) {
		patientDao.save(patient);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateProfile(Patient patient) {
		Patient existingPatient = patientDao.findById(patient.getId() ).orElse(null);
		existingPatient.setFirstName(patient.getFirstName());
		existingPatient.setLastName(patient.getLastName());
		existingPatient.setAddress(patient.getAddress());
		existingPatient.setContactNo1(patient.getContactNo1());
		existingPatient.setContactNo2(patient.getContactNo2());
		
		patientDao.save(existingPatient);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}


}
