package com.example.springprojects.project1.controllers;

import com.example.springprojects.project1.core.service.user.AddUserService;
import com.example.springprojects.project1.core.service.user.DeleteUserService;
import com.example.springprojects.project1.core.service.user.FindAllUserService;
import com.example.springprojects.project1.core.service.user.UpdateUserService;
import com.example.springprojects.project1.dto.todo.FindAllToDoResponse;
import com.example.springprojects.project1.dto.user.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Data
@AllArgsConstructor
public class UserController {
    private final AddUserService addUserService;
    private final FindAllUserService findAllUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    @GetMapping
    public ResponseEntity<FindAllUsersResponse> getAllUsers
            (@RequestBody FindAllUsersRequest request){
        FindAllUsersResponse response = findAllUserService.findAllUsers(request);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<AddUpdateUserResponse> addUser(@RequestBody AddUserRequest request){
        AddUpdateUserResponse response = addUserService.addUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AddUpdateUserResponse> updateUser
            (@RequestBody UpdateUserRequest request){

        AddUpdateUserResponse response = updateUserService.updateUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DeleteUserResponse> deleteUser(@RequestBody DeleteUserRequest request) {

        var response = deleteUserService.deleteUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
