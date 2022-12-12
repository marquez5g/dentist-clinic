package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByDni(String dni);
}
