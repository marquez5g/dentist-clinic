package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.AppointmentDto;
import com.dh.dentistclinic.entities.Appointment;
import com.dh.dentistclinic.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public AppointmentDto save(Appointment appointment) {
        return null;
    }

    @Override
    public void delete(AppointmentDto appointment) {

    }

    @Override
    public List<AppointmentDto> getAll() {
        return null;
    }

    @Override
    public AppointmentDto update(AppointmentDto appointment) {
        return null;
    }
}
