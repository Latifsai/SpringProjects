package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.ToDoDTO;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FindByNameService {
    private final RepositoryJPA repository;

    public List<ToDoDTO> findById(String name) {
        List<ToDoDTO> dto = repository.findByName(name).stream()
                .map(this::convert)
                .toList();

        if (dto.isEmpty()) {
            throw new IllegalArgumentException("Is not found!");
        }
        return dto;
    }

    private ToDoDTO convert(ToDo entity) {
        return new ToDoDTO(entity.getName(), entity.getDescription(), entity.getCreationDate());
    }

}
