package com.api.radio.controllers;

import com.api.radio.dto.DTOUserLoginSuccess;
import com.api.radio.dto.UserLogginDTO;
import com.api.radio.dto.warnings.UserWarnings;
import com.api.radio.entity.Users;
import com.api.radio.services.ServiceUser;
import com.api.radio.utils.JWTEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final ServiceUser serviceUser;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogginDTO userLogginDTO) {

        Users user = serviceUser.getUserByEmail(userLogginDTO.email());

        if(user == null){
            return UserWarnings.userNotFound();
        }

        if(user.getPassword().equals(userLogginDTO.password())){
            return ResponseEntity.ok(new DTOUserLoginSuccess(user.getEmail(), JWTEngine.generateNewJWT(user.getEmail())));
        }

        return UserWarnings.passwordIncorrect();
    }

    @GetMapping("/session")
    public ResponseEntity<DTOUserLoginSuccess> getData(@RequestHeader("Authorization") String authorizationHeader) {

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }

        String token = authorizationHeader.substring("Bearer ".length());
        String subject = JWTEngine.validateToken(token).getSubject();

        DTOUserLoginSuccess user =
                new DTOUserLoginSuccess(subject, token);
        return ResponseEntity.ok(user);    }

}
