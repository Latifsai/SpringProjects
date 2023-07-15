package com.example.springprojects.project1.core.service.toDo;

import com.example.springprojects.project1.core.util.Converters;
import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.FindAllToDoResponse;
import com.example.springprojects.project1.dto.todo.FindAllToDoResponseAdmin;
import com.example.springprojects.project1.dto.todo.ToDoForClient;
import com.example.springprojects.project1.dto.user.FindAllUsersRequest;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import com.example.springprojects.project1.repository.newVar.UserRepositoryJPA;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data
@AllArgsConstructor
public class FindAllToDoService {

    private final RepositoryJPA repositoryJPA;
    private final Converters converters;
    private final UserRepositoryJPA userRepositoryJPA;

    public FindAllToDoResponse findAllToDo() {
        List<ToDo> toDoList = repositoryJPA.findAll();
        if (!toDoList.isEmpty()) {
            List<ToDoForClient> forClients = toDoList.stream()
                    .map(toDo -> converters.convertToDoRequestToToDoForClient(toDo))
                    .toList();
            return new FindAllToDoResponse(forClients, new ArrayList<>());
        } else {
            throw new ValidationException("Database is empty!");

        }


    }

    public FindAllToDoResponseAdmin findAllToDoAdmin(FindAllUsersRequest request) {
       if (checkAdminRights(request)) {

           List<ToDo> toDoList = repositoryJPA.findAll();
           if (!toDoList.isEmpty()) {
               return new FindAllToDoResponseAdmin(toDoList, new ArrayList<>());
           } else {
               throw new ValidationException("Database is empty!");

           }
       }

       return null;
    }

    public ToDoForClient findToDoByID(Integer id) {
        var toDo = repositoryJPA.findById(id);
        if (toDo.isPresent()) {
            return converters.convertToDoRequestToToDoForClient(toDo.get());
        } else {
            throw new ValidationException("This id not found!");
        }
    }

    private boolean checkAdminRights(FindAllUsersRequest request) {

        var user = userRepositoryJPA.findByAccessKey(request.getAccessKey());
        if (user.isPresent()) {
            if (user.get().getUserName().equalsIgnoreCase("admin")){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
