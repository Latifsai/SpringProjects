package com.example.springprojects.project1.repository.old;




import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.ToDoDTO;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {

    ToDoEntity save(ToDoEntity entity);

    List<ToDoEntity> findAll();

    Optional<ToDoEntity> findById(Integer id);

}
