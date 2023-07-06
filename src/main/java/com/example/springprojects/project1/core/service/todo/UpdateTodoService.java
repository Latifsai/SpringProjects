package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.todo.UpdateTodoRequest;

import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateTodoService {
    private final RepositoryJPA repository;

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
