package com.api.radio.services;

import com.api.radio.entity.Users;
import com.api.radio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {

    private final UserRepository userRepository;

    public ServiceUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }


}

