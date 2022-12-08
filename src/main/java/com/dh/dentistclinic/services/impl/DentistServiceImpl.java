package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.DentistDto;
import com.dh.dentistclinic.entities.Dentist;
import com.dh.dentistclinic.repositories.DentistRepository;
import com.dh.dentistclinic.services.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistDto save(DentistDto dentistDto) {
        return mapToDto(dentistRepository.save(mapToEntity(dentistDto)));
    }

    @Override
    public void delete(String credential) {
        Dentist dentist = dentistRepository.findByCredential(credential);
        dentistRepository.delete(dentist);
    }

    @Override
    public DentistDto getByCredential(String credential) {
        return mapToDto(dentistRepository.findByCredential(credential));
    }

    @Override
    public List<DentistDto> getAll() {
        return dentistRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public DentistDto update(DentistDto dentistDto) {
        return mapToDto(dentistRepository.save(mapToEntity(dentistDto)));
    }

    private DentistDto mapToDto (Dentist dentist) {
        return mapper.convertValue(dentist, DentistDto.class);
    }

    private Dentist mapToEntity (DentistDto dentistDto) {
        return mapper.convertValue(dentistDto, Dentist.class);
    }
}
