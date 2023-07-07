package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.core.validation.CoreError;
import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.FindAllToDoResponse;
import com.example.springprojects.project1.dto.todo.ToDoDTO;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindAllToDoService {
    private final RepositoryJPA repository;

    public FindAllToDoService(RepositoryJPA repository) {
        this.repository = repository;
    }

    public FindAllToDoResponse findAll() {

        List<ToDo> entities = repository.findAll();
        List<ToDoDTO> dtos = new ArrayList<>();
        List<CoreError> errors = new ArrayList<>();

        if (entities == null || entities.isEmpty()) {
            errors.add(new CoreError("ToDo database is null"));
        } else {
            for (int i = 0; i < entities.size(); i++) {
                dtos.add(convert(entities.get(i)));
            }
        }

        return new FindAllToDoResponse(dtos, errors);
    }

    private ToDoDTO convert(ToDo entity) {
        return new ToDoDTO(entity.getName(), entity.getDescription(), entity.getCreationDate());
    }
}
