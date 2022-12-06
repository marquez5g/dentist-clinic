package com.dh.dentistclinic.security.config;

import com.dh.dentistclinic.entities.AppUser;
import com.dh.dentistclinic.entities.AppUserRole;
import com.dh.dentistclinic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        AppUser user = new AppUser();
        String hashedPassword = passwordEncoder.encode("password");
        user.setName("Apolo");
        user.setUsername("apolo");
        user.setPassword(hashedPassword);
        user.setEmail("dh@dh.com");
        user.setRole(AppUserRole.USER);
        userRepository.save(user);
    }
}
