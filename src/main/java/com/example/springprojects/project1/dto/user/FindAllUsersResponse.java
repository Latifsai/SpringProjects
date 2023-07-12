package com.example.springprojects.project1.dto.user;

import com.example.springprojects.project1.core.validation.CoreError;
import com.example.springprojects.project1.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class FindAllUsersResponse {

    private List<User> users;
    private List<CoreError> errors;
}
