package com.dh.dentistclinic.repositories;

import com.dh.dentistclinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    Dentist findByCredential(String credential);
    //TODO: at least one method using HQL
}
