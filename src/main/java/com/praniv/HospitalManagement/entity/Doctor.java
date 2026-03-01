package com.praniv.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20)
    private String specialization;

    @Column(nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointment = new ArrayList<>();

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments;
}

