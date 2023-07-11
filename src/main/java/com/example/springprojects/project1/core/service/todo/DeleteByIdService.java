package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.DeleteToDoRequest;
import com.example.springprojects.project1.dto.todo.ToDoDTO;
import com.example.springprojects.project1.dto.todo.ToDoResponse;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class DeleteByIdService {
    private final RepositoryJPA repository;

    public ToDoResponse deleteByID(DeleteToDoRequest request) {

        ToDo deleted = repository.findByIdAndName(request.getId(), request.getName())
                .orElseThrow(() -> new IllegalArgumentException("ToDo with id " + request.getId() + "is not found!"));


        ToDoResponse response = new ToDoResponse();
        response.setCreatedToDoId(deleted.getId());
        return response;
    }

}
