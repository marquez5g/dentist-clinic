package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.dto.PatientDto;
import com.dh.dentistclinic.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    PatientDto findByDni(String dni);
}
