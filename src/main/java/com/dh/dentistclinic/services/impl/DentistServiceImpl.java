package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.DentistDto;
import com.dh.dentistclinic.entities.Dentist;
import com.dh.dentistclinic.repositories.DentistRepository;
import com.dh.dentistclinic.services.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    private final Logger log = LoggerFactory.getLogger(DentistServiceImpl.class);

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistDto save(DentistDto dentistDto) {
        return mapToDto(dentistRepository.save(mapToEntity(dentistDto)));
    }

    @Override
    public void delete(String credential) {
        log.info("Request to delete Dentist : {}", credential);
        Dentist dentist = dentistRepository.findByCredential(credential);
        dentistRepository.delete(dentist);
    }

    @Override
    public DentistDto getByCredential(String credential) {
        log.info("Request to get Dentist : {}", credential);
        return mapToDto(dentistRepository.findByCredential(credential));
    }

    @Override
    public List<DentistDto> getAll() {
        log.info("Request to get all Dentists");
        return dentistRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private DentistDto mapToDto (Dentist dentist) {
        return mapper.convertValue(dentist, DentistDto.class);
    }

    private Dentist mapToEntity (DentistDto dentistDto) {
        return mapper.convertValue(dentistDto, Dentist.class);
    }
}
