package com.example.webserviceapi.repository;

import com.example.webserviceapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
