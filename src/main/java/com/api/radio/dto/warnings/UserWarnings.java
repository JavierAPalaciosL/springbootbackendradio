package com.api.radio.dto.warnings;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class UserWarnings  {
    public static ResponseEntity<Warnings> userNotFound(){
        return ResponseEntity.status(404).body(new Warnings(LocalDate.now().toString(),"User not found"));
    }

    public static ResponseEntity<Warnings> passwordIncorrect(){
        return ResponseEntity.status(403).body(new Warnings(LocalDate.now().toString(),"Password incorrect"));
    }


}
