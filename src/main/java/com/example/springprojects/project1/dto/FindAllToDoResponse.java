package com.example.springprojects.project1.dto;


import com.example.springprojects.project1.core.validation.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindAllToDoResponse {
    private List<ToDoDTO> todos;
    private List<CoreError> errors;
}
