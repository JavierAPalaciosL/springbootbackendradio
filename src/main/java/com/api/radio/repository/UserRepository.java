package com.api.radio.repository;

import com.api.radio.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

    Users findUsersByEmail(String email);

}
