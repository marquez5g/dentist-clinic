package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.AppointmentDto;
import com.dh.dentistclinic.entities.Appointment;
import com.dh.dentistclinic.entities.Dentist;
import com.dh.dentistclinic.entities.Patient;
import com.dh.dentistclinic.repositories.AppointmentRepository;
import com.dh.dentistclinic.repositories.DentistRepository;
import com.dh.dentistclinic.repositories.PatientRepository;
import com.dh.dentistclinic.services.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final ObjectMapper mapper = new ObjectMapper();

    private final AppointmentRepository appointmentRepository;

    private final PatientRepository patientRepository;

    private final DentistRepository dentistRepository;



    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DentistRepository dentistRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {
        Patient patient = patientRepository.findByDni(appointmentDto.getPatient().getDni());
        Dentist dentist = dentistRepository.findByCredential(appointmentDto.getDentist().getCredential());
        Appointment appointment = mapToEntity(appointmentDto);
        appointment.setPatient(patient);
        appointment.setDentist(dentist);
        return mapToDto(appointmentRepository.save(appointment));
    }

    @Override
    public void delete(AppointmentDto appointment) {
        appointmentRepository.delete(mapToEntity(appointment));
    }

    @Override
    public List<AppointmentDto> getAll() {
        return appointmentRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> getAllByDentistCredential(String credential) {
        return appointmentRepository.findAllByDentistCredential(credential).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> getAllByPatientDni(String dni) {
        return appointmentRepository.findAllByPatientDni(dni).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private AppointmentDto mapToDto (Appointment appointment) {
        return mapper.convertValue(appointment, AppointmentDto.class);
    }

    private Appointment mapToEntity (AppointmentDto appointmentDto) {
        return mapper.convertValue(appointmentDto, Appointment.class);
    }
}
