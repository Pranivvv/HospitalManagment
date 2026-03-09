package com.praniv.HospitalManagement.controller;

import com.praniv.HospitalManagement.Dto.AppointmentResponseDto;
import com.praniv.HospitalManagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsOfDoctor() {
//        SecurityProperties.User user = (SecurityProperties.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return ResponseEntity.ok(appointmentService.getAllAppointmentsOfDoctor(user.getId()));
        return null;
    }

}