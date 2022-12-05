package com.dh.dentistclinic.services;

import com.dh.dentistclinic.dto.UserDto;
import com.dh.dentistclinic.entities.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    public UserDto save(User user);
    public void delete(UserDto user);
    public UserDto getByUsername(String username);
    public Set<UserDto> getAll();
    public UserDto update(UserDto user);
}
