package com.example.springprojects.project1.core;


import com.example.springprojects.project1.core.validation.CoreError;
import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.FindAllToDoResponse;
import com.example.springprojects.project1.dto.ToDoDTO;
import com.example.springprojects.project1.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindAllToDoService {
    private ToDoRepository repository;

    public FindAllToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public FindAllToDoResponse findAll() {

//        List<ToDoDTO> dtos = repository.findAll().stream()
//                .map(this::convert)
//                .toList();

        List<ToDoEntity> entities = repository.findAll();
        List<ToDoDTO> dtos = new ArrayList<>();
        List<CoreError> errors = new ArrayList<>();

        if (entities == null || entities.isEmpty()) {
            errors.add(new CoreError("ToDo database is null"));
            }
        else {
            for (int i = 0; i < entities.size(); i++) {
                dtos.add(convert(entities.get(i)));
            }
        }

        return  new FindAllToDoResponse(dtos, errors);
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO( entity.getName(), entity.getDescription());
    }
}
