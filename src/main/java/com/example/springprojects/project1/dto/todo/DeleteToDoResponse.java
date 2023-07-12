package com.example.springprojects.project1.dto.todo;

import com.example.springprojects.project1.core.validation.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DeleteToDoResponse {
    private Integer id;
    private List<CoreError> errors;
}
