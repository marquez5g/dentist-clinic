package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
