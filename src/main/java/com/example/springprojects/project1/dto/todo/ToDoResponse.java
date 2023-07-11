package com.example.springprojects.project1.dto.todo;



import com.example.springprojects.project1.core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ToDoResponse {
    private Integer createdToDoId;
    private List<CoreError> errors;
    private LocalDateTime creationDate;

}
