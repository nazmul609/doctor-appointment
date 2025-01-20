package com.peytosoft.AppointmentService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peytosoft.AppointmentService.Model.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment,Integer> {

	List<Appointment> findByPatientId(Integer patientId);

	List<Appointment> findByDoctorId(Integer doctorId);

}
