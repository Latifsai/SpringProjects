package com.example.springprojects.project1.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteToDoRequest {
    private Integer id;
    private String name;
}
