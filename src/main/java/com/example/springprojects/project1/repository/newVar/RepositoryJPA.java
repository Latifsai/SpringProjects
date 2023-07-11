package com.example.springprojects.project1.repository.newVar;

import com.example.springprojects.project1.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RepositoryJPA extends JpaRepository<ToDo, Integer> {
    Optional<ToDo> findByIdAndName(Integer id, String name);

    List<ToDo> findByName(String name);

    List<ToDo> findByDescription(String description);
}
