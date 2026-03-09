package com.praniv.HospitalManagement.service;

import com.praniv.HospitalManagement.Dto.AppointmentResponseDto;
import com.praniv.HospitalManagement.Dto.CreateAppointmentRequestDto;
import com.praniv.HospitalManagement.entity.Appointment;
import com.praniv.HospitalManagement.entity.Doctor;
import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.repository.AppointmentRepository;
import com.praniv.HospitalManagement.repository.DoctorRepository;
import com.praniv.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) {
        Long doctorId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));
        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointment().add(appointment); // to maintain consistency

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResponseDto.class);
    }

    @Transactional
    public Appointment reAssignAppointmentToOtherDoctor(Long doctorId, Long appointmentId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()-> new EntityNotFoundException("Appointment is invalid"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor with id is not available"));
        appointment.setDoctor(doctor);
        doctor.getAppointment().add(appointment);
        return appointment;
    }

    public List<AppointmentResponseDto> getAllAppointmentOfDoctor(Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor id is not valid"));

        return doctor.getAppointment()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                .toList();
    }
}
