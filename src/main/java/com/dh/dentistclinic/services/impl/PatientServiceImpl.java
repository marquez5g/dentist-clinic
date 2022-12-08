package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.PatientDto;
import com.dh.dentistclinic.entities.Patient;
import com.dh.dentistclinic.repositories.PatientRepository;
import com.dh.dentistclinic.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    
    private final PatientRepository patientRepository;
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        return mapToDto(patientRepository.save(mapToEntity(patientDto)));
    }

    @Override
    public void delete(PatientDto patient) {
        patientRepository.delete(mapToEntity(patient));
    }

    @Override
    public PatientDto getByDni(String dni) {
        return patientRepository.findByDni(dni);
    }

    @Override
    public List<PatientDto> getAll() {
        return patientRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PatientDto update(PatientDto patient) {
        return mapToDto(patientRepository.save(mapToEntity(patient)));
    }

    private PatientDto mapToDto (Patient patient) {
        return mapper.convertValue(patient, PatientDto.class);
    }

    private Patient mapToEntity (PatientDto patientDto) {
        return mapper.convertValue(patientDto, Patient.class);
    }
}
