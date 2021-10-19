package com.example.webserviceapi.controller;


import com.example.webserviceapi.entities.User;
import com.example.webserviceapi.exception.ResourceNotFoundException;

import com.example.webserviceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity < List < User >>getAllUsers(){
        return  ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("{id}")
    public ResponseEntity < User > getUserById(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity < User > createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    // build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User UserDetails) {
        User updateUser = userService.getUserById(id);
               // .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        updateUser.setFullname(UserDetails.getFullname());
        updateUser.setPwd(UserDetails.getPwd());
        updateUser.setEmail(UserDetails.getEmail());
        updateUser.setBirth(UserDetails.getBirth());
        updateUser.setNin(UserDetails.getNin());
        updateUser.setAdresse(UserDetails.getAdresse());
        updateUser.setGenre(UserDetails.getGenre());

        userService.updateUser(updateUser);
        return ResponseEntity.ok().body(this.userService.updateUser(UserDetails));

    }

    // build delete User REST API
    @DeleteMapping("{id}")

        public HttpStatus deleteUser(@PathVariable long id) {
            this.userService.deleteUser(id);
            return HttpStatus.OK;


    }

}
