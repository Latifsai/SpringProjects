package com.example.springprojects.project1.repository.newVar;

import com.example.springprojects.project1.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RepositoryJPA extends JpaRepository<ToDo, Integer> {

    List<ToDo> findByName (String name);
}
