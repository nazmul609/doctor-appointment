package com.peytosoft.DoctorService.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.peytosoft.DoctorService.Model.Doctor;
import com.peytosoft.DoctorService.Service.DoctorService;




@RestController
@RequestMapping("doctor")
public class DoctorController {
	
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
	
	@GetMapping("allDoctors")
    public ResponseEntity<List<Doctor>> getAllDoctor(){

        return doctorService.getAllDoctor();
    }
	
	@GetMapping("getDoctorBydoctorId/{id}")
	public ResponseEntity<Optional<Doctor>> getDoctorBydoctorId(@PathVariable Integer id){
	    return doctorService.getDoctorBydoctorId(id);
	}
	
	@GetMapping("getDoctorByFirstName/{firstName}")
	public ResponseEntity<Doctor> getDoctorByfirstName(@PathVariable String firstName){
	    return doctorService.getDoctorByfirstName(firstName);
	}
	
	@GetMapping("getDoctorByLastName/{lastName}")
	public ResponseEntity<Doctor> getDoctorBylastName(@PathVariable String lastName){
	    return doctorService.getDoctorBylastName(lastName);
	}
	
	@GetMapping("getDoctorBySpeciality/{spec}")
	public ResponseEntity<List<Doctor>> getDoctorByspeciality(@PathVariable String spec){
	    return doctorService.getDoctorByspeciality(spec);
	}
	
	@PutMapping("updateProfile")
    public ResponseEntity<String> updateProfile(@RequestBody Doctor doctor){
        return doctorService.updateProfile(doctor);
    }
	
	

}
