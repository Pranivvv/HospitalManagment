package com.praniv.HospitalManagement.service;

import com.praniv.HospitalManagement.entity.Insurance;
import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.repository.InsuranceRepository;
import com.praniv.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Long id, Insurance insurance){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found with Id:"+id));

        patient.setInsurance(insurance);
//        insurance.setPatient(patient);
        return patient;
    }

    @Transactional
    public Patient removeInsurance(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("patient is not available"));
        patient.setInsurance(null);
        return patient;
    }
}
