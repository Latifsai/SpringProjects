package com.example.springprojects.project1.core.util;

import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.todo.AddToDoRequest;

public class Converters {
    public ToDoEntity convertToEntity(AddToDoRequest request) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
