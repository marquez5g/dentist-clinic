package com.dh.dentistclinic.services;

import com.dh.dentistclinic.dto.AppointmentDto;
import com.dh.dentistclinic.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentDto save(Appointment user);
    void delete(AppointmentDto user);
    List<AppointmentDto> getAll();
    AppointmentDto update(AppointmentDto user);
}
