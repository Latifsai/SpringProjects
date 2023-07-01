package com.example.springprojects.project1.repository.newVar;

import com.example.springprojects.project1.domain.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJPA extends JpaRepository<ToDoEntity, Integer> {

}
