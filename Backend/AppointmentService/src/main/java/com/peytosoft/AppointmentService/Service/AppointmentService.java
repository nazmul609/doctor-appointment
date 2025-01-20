package com.peytosoft.AppointmentService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.peytosoft.AppointmentService.Dao.AppointmentDao;
import com.peytosoft.AppointmentService.Model.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentDao appointmentDao;

	public ResponseEntity<List<Appointment>> getAppointmentBypatientId(Integer patientId) {
		try {
            return new ResponseEntity<>(appointmentDao.findByPatientId(patientId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addAppointment(Appointment appointment) {
		appointmentDao.save(appointment);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Appointment>> getAppointmentBydoctorId(Integer doctorId) {
		try {
            return new ResponseEntity<>(appointmentDao.findByDoctorId(doctorId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateStatus(Appointment appointment) {
		Appointment existingAppointment = appointmentDao.findById(appointment.getAppointmentId() ).orElse(null);
		existingAppointment.setAppointmentStatus(appointment.getAppointmentStatus());
		appointmentDao.save(existingAppointment);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Appointment>> getAllAppointment() {
		try {
            return new ResponseEntity<>(appointmentDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
