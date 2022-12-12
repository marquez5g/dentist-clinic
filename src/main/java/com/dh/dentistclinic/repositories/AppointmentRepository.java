package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDentistCredential(String credential);

    List<Appointment> findAllByPatientDni(String dni);
}
