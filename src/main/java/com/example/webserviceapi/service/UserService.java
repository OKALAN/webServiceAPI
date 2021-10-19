package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User User);

    User updateUser(User User);

    List<User> getAllUser();

    User getUserById(long UserId);

    void deleteUser(long id);
}
