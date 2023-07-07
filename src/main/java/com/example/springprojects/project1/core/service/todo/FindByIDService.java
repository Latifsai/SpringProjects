package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.ToDoDTO;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FindByIDService {
    private final RepositoryJPA repository;

    public ToDoDTO findById(Integer id) {
        return repository.findById(id)
                .map(this::convert)
                .orElseThrow(() -> new IllegalArgumentException("ToDo with id " + id + " is not found!"));
    }

    private ToDoDTO convert(ToDo entity) {
        return new ToDoDTO(entity.getName(), entity.getDescription(), entity.getCreationDate());
    }

}
