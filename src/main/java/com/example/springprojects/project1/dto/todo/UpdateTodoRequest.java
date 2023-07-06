package com.example.springprojects.project1.dto.todo;

import lombok.Data;

@Data
public class UpdateTodoRequest {
    private Integer id;
    private String name;
    private String description;

}
