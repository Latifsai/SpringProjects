package com.example.springprojects.project1.core.util;

import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.domain.User;
import com.example.springprojects.project1.dto.todo.AddToDoRequest;
import com.example.springprojects.project1.dto.user.AddUserRequest;
import org.springframework.stereotype.Service;

@Service
public class Converters {
    public User convertUserRequestToEntity(AddUserRequest request) {
        User user = new User();
        user.setUserName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public ToDo convertToDoRequestToEntity(AddToDoRequest request) {
        ToDo entity = new ToDo();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }

}
