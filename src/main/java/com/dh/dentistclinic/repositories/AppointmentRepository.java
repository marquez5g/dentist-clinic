package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDentistCredential(String credential);

    @Query("SELECT a FROM Appointment a WHERE a.patient.dni = ?1")
    List<Appointment> findAllByPatientDni(String dni);
}
