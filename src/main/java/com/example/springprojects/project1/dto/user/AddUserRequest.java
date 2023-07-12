package com.example.springprojects.project1.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserRequest {
    private String username;
    private String password;
    private String email;
}
