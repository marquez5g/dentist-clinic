package com.dh.dentistclinic.controllers;

import com.dh.dentistclinic.dto.UserDto;
import com.dh.dentistclinic.entities.User;
import com.dh.dentistclinic.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        UserDto savedUser = userService.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
        UserDto user = userService.getByUsername(username);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<Set<UserDto>> getAll() {
        Set<UserDto> userDtos = userService.getAll();
        return ResponseEntity.ok().body(userDtos);
    }

}

