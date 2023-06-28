package com.example.springprojects.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoDTO {

    private String name;
    private String description;
}
