package com.dh.dentistclinic.controllers;

import com.dh.dentistclinic.dto.PatientDto;
import com.dh.dentistclinic.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patient) {
        PatientDto savedUser = patientService.save(patient);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<PatientDto> getByDni(@PathVariable String dni) {
        PatientDto patient = patientService.getByDni(dni);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll() {
        List<PatientDto> dentistDtos = patientService.getAll();
        return ResponseEntity.ok().body(dentistDtos);
    }
}
