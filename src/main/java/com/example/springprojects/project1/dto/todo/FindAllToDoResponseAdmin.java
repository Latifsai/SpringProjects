package com.example.springprojects.project1.dto.todo;

import com.example.springprojects.project1.core.validation.CoreError;
import com.example.springprojects.project1.domain.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindAllToDoResponseAdmin {
    private List<ToDo> toDos;
    private List<CoreError> errors;
}
