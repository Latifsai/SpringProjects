package com.example.springprojects.project1.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateToDoRequest {
    private Integer id;
    private String newName;
    private String newDescription;
    private String accessKey;
}
