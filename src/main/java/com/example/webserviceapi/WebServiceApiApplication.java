package com.example.webserviceapi;

import com.example.webserviceapi.entities.User;
import com.example.webserviceapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.Null;

@SpringBootApplication
public class WebServiceApiApplication  {
     UserService userService ;

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApiApplication.class, args);


    }


}
