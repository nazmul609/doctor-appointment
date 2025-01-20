package com.peytosoft.AppointmentService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peytosoft.AppointmentService.Model.Appointment;
import com.peytosoft.AppointmentService.Service.AppointmentService;




@RestController
@RequestMapping("appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping("allAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointment(){

        return appointmentService.getAllAppointment();
    }
	
	@PostMapping("addAppointment")
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment){
        return appointmentService.addAppointment(appointment);
    }
	
	@GetMapping("getAppointmentBypatientId/{patientId}")
	public ResponseEntity<List<Appointment>> getAppointmentBypatientId(@PathVariable Integer patientId){
	    return appointmentService.getAppointmentBypatientId(patientId);
	}
	
	@GetMapping("getAppointmentBydoctorId/{doctorId}")
	public ResponseEntity<List<Appointment>> getAppointmentBydoctorId(@PathVariable Integer doctorId){
	    return appointmentService.getAppointmentBydoctorId(doctorId);
	}
	
	@PutMapping("updateStatus")
    public ResponseEntity<String> updateStatus(@RequestBody Appointment appointment){
        return appointmentService.updateStatus(appointment);
    }

}
