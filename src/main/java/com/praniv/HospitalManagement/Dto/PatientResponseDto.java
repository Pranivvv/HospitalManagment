package com.praniv.HospitalManagement.Dto;

import com.praniv.HospitalManagement.entity.Type.BloodGroup;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroup bloodGroup;
}
