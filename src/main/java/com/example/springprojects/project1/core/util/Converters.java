package com.example.springprojects.project1.core.util;

import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.AddToDoRequest;
import org.springframework.stereotype.Component;

@Component
public class Converters {
    public ToDo convertToEntity(AddToDoRequest request) {
        ToDo entity = new ToDo();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
