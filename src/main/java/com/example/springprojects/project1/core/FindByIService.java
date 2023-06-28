package com.example.springprojects.project1.core;

import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.ToDoDTO;
import com.example.springprojects.project1.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByIService {
    private final ToDoRepository repository;

    public ToDoDTO findById(Integer id) {
        return repository.findById(id)
                .map(this::convert)
                .orElseThrow(() -> new IllegalArgumentException("ToDo with id " + id + " is not found!"));
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO(entity.getName(), entity.getDescription());
    }

}
