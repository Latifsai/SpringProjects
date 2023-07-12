package com.example.springprojects.project1.dto.user;

import com.example.springprojects.project1.core.validation.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DeleteUserResponse {

    private Integer id;
    private String name;
    private List<CoreError> errors;
}
