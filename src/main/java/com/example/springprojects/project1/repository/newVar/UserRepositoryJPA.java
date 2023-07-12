package com.example.springprojects.project1.repository.newVar;

import com.example.springprojects.project1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositoryJPA extends JpaRepository<User, Integer> {

    Optional<User> findByAccessKey(String accessKey);
}
