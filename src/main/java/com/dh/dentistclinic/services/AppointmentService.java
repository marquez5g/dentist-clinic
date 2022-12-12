package com.dh.dentistclinic.services;

import com.dh.dentistclinic.dto.AppointmentDto;
import java.util.List;

public interface AppointmentService {
    AppointmentDto save(AppointmentDto user);
    void delete(AppointmentDto user);
    List<AppointmentDto> getAll();
    List<AppointmentDto> getAllByDentistCredential(String credential);
    List<AppointmentDto> getAllByPatientDni(String dni);
}
