package com.praniv.HospitalManagement.service;

import com.praniv.HospitalManagement.Dto.DoctorResponseDto;
import com.praniv.HospitalManagement.Dto.OnboardDoctorRequestDto;
import com.praniv.HospitalManagement.entity.Doctor;
import com.praniv.HospitalManagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctorResponseDto> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .toList();
    }

    @Transactional
    public DoctorResponseDto onBoardNewDoctor(OnboardDoctorRequestDto onBoardDoctor){
        Doctor doctor = doctorRepository.save(modelMapper.map(onBoardDoctor, Doctor.class));
        return modelMapper.map(doctor, DoctorResponseDto.class);
    }
}
