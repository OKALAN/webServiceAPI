package com.example.webserviceapi.service;

import com.example.webserviceapi.entities.User;
import com.example.webserviceapi.exception.ResourceNotFoundException;
import com.example.webserviceapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final com.example.webserviceapi.repository.UserRepository UserRepository;

    public UserServiceImpl(com.example.webserviceapi.repository.UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }


    @Override
    public User createUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public User updateUser (User User) {
        Optional < User > UserDb = this.UserRepository.findById(User.getId());

        if (UserDb.isPresent()) {
            User UserUpdate = UserDb.get();
            UserUpdate.setId(User.getId());
            UserUpdate .setFullname(User.getFullname());
            UserUpdate .setPwd(User.getPwd());
            UserUpdate .setEmail(User.getEmail());
            UserUpdate .setBirth(User.getBirth());
            UserUpdate .setNin(User.getNin());
            UserUpdate .setAdresse(User.getAdresse());
            UserUpdate .setGenre(User.getGenre());
            UserRepository.save(UserUpdate);
            return UserUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + User.getId());
        }
    }

    @Override
    public List< User > getAllUser() {
        return this.UserRepository.findAll();
    }

    @Override
    public User getUserById(long UserId) {

        Optional<User> UserDb = this.UserRepository.findById(UserId);

        if (UserDb.isPresent()) {
            return UserDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + UserId);
        }
    }

    @Override
    public void deleteUser(long UserId) {
        Optional < User > UserDb = this.UserRepository.findById(UserId);

        if (UserDb.isPresent()) {
            this.UserRepository.delete(UserDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + UserId);
        }

    }
}
