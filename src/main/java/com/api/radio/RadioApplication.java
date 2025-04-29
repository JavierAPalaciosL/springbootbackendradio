package com.api.radio;

import com.api.radio.entity.Users;
import com.api.radio.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RadioApplication implements CommandLineRunner {

    @Autowired
    private ServiceUser serviceUser;

    public static void main(String[] args) {
        SpringApplication.run(RadioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        serviceUser.saveUser(new Users("javier@gmail.com", "1234"));
        serviceUser.saveUser(new Users("alberto@gmail.com", "1234"));
    }
}
