package com.praniv.HospitalManagement.service;

import com.praniv.HospitalManagement.entity.Appointment;
import com.praniv.HospitalManagement.entity.Doctor;
import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.repository.AppointmentRepository;
import com.praniv.HospitalManagement.repository.DoctorRepository;
import com.praniv.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment bookAppointment(Long patientId, Long doctorId, Appointment appointment){

        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient Not Found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("Patient Not Found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        patient.getAppointment().add(appointment);
        doctor.getAppointment().add(appointment);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToOtherDoctor(Long doctorId, Long appointmentId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()-> new EntityNotFoundException("Appointment is invalid"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor with id is not available"));
        appointment.setDoctor(doctor);
        doctor.getAppointment().add(appointment);
        return appointment;
    }
}
