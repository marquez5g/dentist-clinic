package com.dh.dentistclinic.controllers;

import com.dh.dentistclinic.dto.AppUserDto;
import com.dh.dentistclinic.entities.AppUser;
import com.dh.dentistclinic.security.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService userService;

    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    /*@PostMapping
    public ResponseEntity<AppUserDto> createUser(@RequestBody User user) {
        AppUserDto savedUser = userService.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<AppUserDto> getByUsername(@PathVariable String username) {
        AppUserDto user = userService.getByUsername(username);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<Set<AppUserDto>> getAll() {
        Set<AppUserDto> userDtos = userService.getAll();
        return ResponseEntity.ok().body(AppUserDtos);
    }*/

}

