package com.example.springprojects.project1.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserRequest {

    private String username;
    private String newPassword;
    private String newEmail;
    private String accessKey;

}
