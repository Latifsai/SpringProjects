package com.example.springprojects.project1.core.service.todo;


import com.example.springprojects.project1.core.util.Converters;
import com.example.springprojects.project1.dto.todo.AddToDoRequest;
import com.example.springprojects.project1.dto.todo.ToDoResponse;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Data
@AllArgsConstructor
public class AddToDoService {
    private final RepositoryJPA repository;
    private final Converters convert;
    public ToDoResponse add(AddToDoRequest request) {

        var entity = convert.convertToEntity(request);
        entity.setCreationDate(LocalDateTime.now());

        var createdEntity = repository.save(entity);
        var response = new ToDoResponse();
        response.setCreatedToDoId(createdEntity.getId());
        return response;

    }

}
