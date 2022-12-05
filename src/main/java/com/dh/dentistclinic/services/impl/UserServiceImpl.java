package com.dh.dentistclinic.services.impl;

import com.dh.dentistclinic.dto.UserDto;
import com.dh.dentistclinic.entities.User;
import com.dh.dentistclinic.repositories.UserRepository;
import com.dh.dentistclinic.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(User user) {
        User userFromDb = userRepository.save(user);
        return mapper.convertValue(userFromDb, UserDto.class);
    }

    @Override
    public void delete(UserDto user) {

    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return mapper.convertValue(user, UserDto.class);
    }

    @Override
    public Set<UserDto> getAll() {
        Set<User> users = new HashSet<>(userRepository.findAll());
        Set<UserDto> userDtos = new HashSet<>();
        for (User user:
             users) {
            userDtos.add(mapper.convertValue(user, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public UserDto update(UserDto user) {
        return null;
    }
}
