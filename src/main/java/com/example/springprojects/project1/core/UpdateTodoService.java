package com.example.springprojects.project1.core;

import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.ToDoDTO;
import com.example.springprojects.project1.dto.UpdateTodoRequest;
import com.example.springprojects.project1.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateTodoService {
    private final ToDoRepository repository;

    public void update(UpdateTodoRequest request) {
        repository.findById(request.getId())
                .map(entity -> updateFields(entity,request))
                .ifPresent(repository::save);
    }

    private ToDoEntity updateFields(ToDoEntity entity, UpdateTodoRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setId(request.getId());
        return entity;
    }

}