package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    @Query("SELECT d FROM Dentist d WHERE d.credential = ?1")
    Dentist findByCredential(String credential);
}
