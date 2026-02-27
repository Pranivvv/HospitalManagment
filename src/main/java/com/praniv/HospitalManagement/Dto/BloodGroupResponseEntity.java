package com.praniv.HospitalManagement.Dto;

import com.praniv.HospitalManagement.entity.Type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BloodGroupResponseEntity {
    private BloodGroup bloodGroup;
    private Long count;
}
