package com.praniv.HospitalManagement;

import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void getPatientTest(){
        List<Patient> allPatient = patientRepository.findAll();
        System.out.println(allPatient);
    }
}
