package com.example.springprojects.project1.controllers;

import com.example.springprojects.project1.core.service.toDo.AddToDoService;
import com.example.springprojects.project1.core.service.toDo.FindAllToDoService;
import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.*;
import com.example.springprojects.project1.dto.user.FindAllUsersRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Data
@AllArgsConstructor
public class ToDoController {
    private final AddToDoService add;
    private final FindAllToDoService findAllToDoService;

    @GetMapping
    public ResponseEntity<FindAllToDoResponse> getAllUsers() {
        FindAllToDoResponse response = findAllToDoService.findAllToDo();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/admin")
    public ResponseEntity<FindAllToDoResponseAdmin> getAllUsersForAdmin(@RequestBody FindAllUsersRequest request) {

        FindAllToDoResponseAdmin responseAdmin = findAllToDoService.findAllToDoAdmin(request);
        return new ResponseEntity<>(responseAdmin, HttpStatus.FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoForClient> getToDoById(@PathVariable Integer id) {
        return new ResponseEntity<>(findAllToDoService.findToDoByID(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<AddUpdateToDoResponse> addUser(@RequestBody AddToDoRequest request) {
        AddUpdateToDoResponse response = add.addToDo(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
