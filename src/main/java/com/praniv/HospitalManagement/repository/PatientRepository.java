package com.praniv.HospitalManagement.repository;

import com.praniv.HospitalManagement.Dto.BloodGroupResponseEntity;
import com.praniv.HospitalManagement.entity.Patient;
import com.praniv.HospitalManagement.entity.Type.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByName(String name);

    Optional<Patient> findByNameAndDob(String name, LocalDateTime dob);

    List<Patient> findByNameOrEmail(String name, String email);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

    List<Patient> findByDobBetween(LocalDate startDate, LocalDate endDate);

    @Query("Select p from Patient p where p.dob>:dob")
    List<Patient> findByBornAfter(@Param("dob") LocalDate date);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

//    @Query("Select p.bloodGroup, count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> findCountByBloodGroup();
    @Query("Select new com.praniv.HospitalManagement.Dto.BloodGroupResponseEntity(p.bloodGroup, count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupResponseEntity> findCountByBloodGroup();

    @Query(value = "select * from Patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

    @Modifying
    @Transactional
    @Query("Update Patient p set p.name = :name where p.id = :id ")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
