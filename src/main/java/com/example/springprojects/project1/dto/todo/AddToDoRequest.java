package com.example.springprojects.project1.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddToDoRequest {
    private String name;
    private String description;
    private String accessKey;
}
