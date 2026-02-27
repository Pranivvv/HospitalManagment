package com.praniv.HospitalManagement;

import com.praniv.HospitalManagement.Dto.BloodGroupResponseEntity;
import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.entity.Type.BloodGroup;
import com.praniv.HospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void getPatientTest(){
//        List<Patient> allPatient = patientRepository.findAll();
        Page<Patient> allPatient = patientRepository.findAllPatient(PageRequest.of(1, 2, Sort.by("name")));
        System.out.println(allPatient);
    }

    @Test
    public void getPatientByNameTest(){
        Optional<Patient> patient = patientRepository.findByName("Rahul Sharma");
        System.out.println(patient.orElseThrow() );
    }

    @Test
    public void getPatientByBloodGroupTest(){
        List<Patient> patient = patientRepository.findByBloodGroup(BloodGroup.AB_POSITIVE);
        System.out.println(patient );
    }

    @Test
    public void getCountByBloodGroupTest(){
        List<BloodGroupResponseEntity> patient = patientRepository.findCountByBloodGroup();
        System.out.println(patient);
    }

    @Test
    public void getPatientByNameContainingTest(){
        List<Patient> patient = patientRepository.findByNameContainingOrderByIdDesc("t");
        System.out.println(patient );
    }

    @Test
    public void getPatientByNameOrEmailTest(){
        List<Patient> patient = patientRepository.findByNameOrEmail("Rahul Sharma", "sneha.patil@gmail.com");
        System.out.println(patient);
    }

    @Test
    public void getPatientBornAfterTest(){
        List<Patient> patient = patientRepository.findByBornAfter(LocalDate.of(1998,5, 4 ));
        System.out.println(patient);
    }

    @Test
    public void getPatientByDobBetweenTest(){
        List<Patient> patient = patientRepository.findByDobBetween(LocalDate.of(1996,5, 4 ), LocalDate.of(1998,12, 4 ));
        System.out.println(patient);
    }

    @Test
    public void updatePatientName(){
        int p = patientRepository.updateNameWithId("Updated Name", 1L);
    }
}
