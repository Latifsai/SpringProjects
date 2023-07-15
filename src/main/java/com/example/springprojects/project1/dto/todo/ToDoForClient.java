package com.example.springprojects.project1.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoForClient {
    private Integer id;
    private String name;
    private String description;
}
