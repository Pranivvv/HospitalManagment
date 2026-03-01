package com.praniv.HospitalManagement;

import com.praniv.HospitalManagement.entity.Appointment;
import com.praniv.HospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void appoitmentTest(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 3, 2, 20, 10, 50))
                .reason("cold")
                .status("Pending")
                .build();

        Appointment a = appointmentService.bookAppointment(1L, 1L, appointment);
        System.out.println(appointment);

        appointment = appointmentService.reAssignAppointmentToOtherDoctor(3L, appointment.getId());

        System.out.println(appointment);
    }


}
