package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.AppointmentDto;
import com.dh.dentistclinic.dto.DentistDto;
import com.dh.dentistclinic.dto.PatientDto;
import com.dh.dentistclinic.services.AppointmentService;
import com.dh.dentistclinic.services.DentistService;
import com.dh.dentistclinic.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AppointmentServiceImplTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DentistService dentistService;

    @Autowired
    private PatientService patientService;


    @BeforeEach
    void setUp() {
        DentistDto dentistDto = new DentistDto();
        dentistDto.setCredential("123456789");
        dentistDto.setName("John");
        dentistDto.setLastName("Doe");
        dentistService.save(dentistDto);

        PatientDto patientDto = new PatientDto();
        patientDto.setName("Apolo");
        patientDto.setLastName("Marquez");
        patientDto.setAddress("Calle siempre viva 123");
        patientDto.setDni("12345678");
        patientDto.setDischargeDate("2022-01-01");
        patientService.save(patientDto);

        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setDentist(dentistDto);
        appointmentDto.setPatient(patientDto);
        appointmentDto.setDateAndTime("2021-01-01 10:00:00");
        appointmentService.save(appointmentDto);
    }

    @Test
    void save() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setPatient(patientService.getAll().get(0));
        appointmentDto.setDentist(dentistService.getAll().get(0));
        appointmentDto.setDateAndTime("2021-01-01T10:00:00");

        AppointmentDto savedAppointment = appointmentService.save(appointmentDto);
        assertNotNull(savedAppointment);
    }

    @Test
    void getAllByDentistCredential() {
        List<AppointmentDto> appointmentDtoList = appointmentService.getAllByDentistCredential("123456789");
        assertEquals(appointmentDtoList.get(0).getDentist().getCredential(), "123456789");
    }

    @Test
    void getAllByPatientDni() {
        List<AppointmentDto> appointmentDtoList = appointmentService.getAllByPatientDni("12345678");
        assertEquals(appointmentDtoList.get(0).getPatient().getDni(), "12345678");

    }
}