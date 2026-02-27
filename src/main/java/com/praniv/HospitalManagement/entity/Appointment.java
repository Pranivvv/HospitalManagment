package com.praniv.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 250)
    private String reason;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;
}
