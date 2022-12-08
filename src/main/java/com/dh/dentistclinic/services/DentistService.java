package com.dh.dentistclinic.services;

import com.dh.dentistclinic.dto.DentistDto;
import java.util.List;

public interface DentistService {
    DentistDto save(DentistDto dentist);
    void delete(String credential);
    DentistDto getByCredential(String credential);
    List<DentistDto> getAll();
    DentistDto update(DentistDto dentist);
}
