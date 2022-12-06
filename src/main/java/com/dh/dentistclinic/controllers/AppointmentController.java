package com.dh.dentistclinic.controllers;

import com.dh.dentistclinic.dto.AppointmentDto;
import com.dh.dentistclinic.entities.Appointment;
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
    public ResponseEntity<AppointmentDto> createPatient(@RequestBody Appointment pppointment) {
        AppointmentDto savedUser = appointmentService.save(pppointment);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAll() {
        List<AppointmentDto> dentistDtos = appointmentService.getAll();
        return ResponseEntity.ok().body(dentistDtos);
    }
}
