package com.dh.dentistclinic.controllers;

import com.dh.dentistclinic.dto.AppointmentDto;
import com.dh.dentistclinic.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointment) {
        AppointmentDto savedAppointment = appointmentService.save(appointment);
        return ResponseEntity.ok().body(savedAppointment);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<AppointmentDto> appointmentDtos = appointmentService.getAll();
        return ResponseEntity.ok().body(appointmentDtos);
    }

    @GetMapping("/patients/{dni}")
    public ResponseEntity<List<AppointmentDto>> getAllByPatientDni(@PathVariable String dni) {
        List<AppointmentDto> appointmentDtos = appointmentService.getAllByPatientDni(dni);
        return ResponseEntity.ok().body(appointmentDtos);
    }

    @GetMapping("/dentists/{credential}")
    public ResponseEntity<List<AppointmentDto>> getAllByDentistCredential(@PathVariable String credential) {
        List<AppointmentDto> appointmentDtos = appointmentService.getAllByDentistCredential(credential);
        return ResponseEntity.ok().body(appointmentDtos);
    }
}
