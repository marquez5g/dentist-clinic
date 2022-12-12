package com.dh.dentistclinic.services;

import com.dh.dentistclinic.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    PatientDto save(PatientDto user);
    void delete(PatientDto user);
    PatientDto getByDni(String username);
    List<PatientDto> getAll();
}
