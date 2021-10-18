package com.example.webserviceapi.controller;


import com.example.webserviceapi.entities.User;
import com.example.webserviceapi.exception.ResourceNotFoundException;
import com.example.webserviceapi.repository.UserRepository;
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
    private com.example.webserviceapi.repository.UserRepository UserRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }

    // build create User REST API
    @PostMapping
    public User createUser(@RequestBody User User) {
        return UserRepository.save(User);
    }

    // build get User by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable  long id){
        User User = UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(User);
    }

    // build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User UserDetails) {
        User updateUser = UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        updateUser.setFullname(UserDetails.getFullname());
        updateUser.setPwd(UserDetails.getPwd());
        updateUser.setEmail(UserDetails.getEmail());
        updateUser.setBirth(UserDetails.getBirth());
        updateUser.setNin(UserDetails.getNin());
        updateUser.setAdresse(UserDetails.getAdresse());
        updateUser.setGenre(UserDetails.getGenre());

        UserRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    // build delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        User User = UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        UserRepository.delete(User);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
