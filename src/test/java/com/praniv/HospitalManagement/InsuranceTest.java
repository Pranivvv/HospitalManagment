package com.praniv.HospitalManagement;

import com.praniv.HospitalManagement.entity.Insurance;
import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void addInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .policyNumber("ABC123")
                .policyProvider("ABC")
                .validTill(LocalDateTime.now().plusYears(1))
                .build();
        Patient patient = insuranceService.assignInsuranceToPatient(1L , insurance);
        System.out.println(patient);

        System.out.println(insuranceService.removeInsurance(patient.getId()));

    }
}
