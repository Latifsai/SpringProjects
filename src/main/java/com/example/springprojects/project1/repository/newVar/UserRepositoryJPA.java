package com.example.springprojects.project1.repository.newVar;

import com.example.springprojects.project1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositoryJPA extends JpaRepository<User, Integer> {

}
