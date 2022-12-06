package com.dh.dentistclinic.controllers;

import com.dh.dentistclinic.dto.DentistDto;
import com.dh.dentistclinic.services.DentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {
    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping
    public ResponseEntity<DentistDto> createUser(@RequestBody DentistDto dentistDto) {
        DentistDto savedUser = dentistService.save(dentistDto);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/{credential}")
    public ResponseEntity<DentistDto> getByUsername(@PathVariable String credential) {
        DentistDto dentist = dentistService.getByCredential(credential);
        return ResponseEntity.ok().body(dentist);
    }

    @GetMapping
    public ResponseEntity<List<DentistDto>> getAll() {
        List<DentistDto> dentistDtos = dentistService.getAll();
        return ResponseEntity.ok().body(dentistDtos);
    }
}
