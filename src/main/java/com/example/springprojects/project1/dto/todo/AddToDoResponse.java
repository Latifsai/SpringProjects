package com.example.springprojects.project1.dto.todo;



import com.example.springprojects.project1.core.validation.CoreError;
import com.example.springprojects.project1.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AddToDoResponse {
    private Integer createdToDoId;
    private List<CoreError> errors;
    private LocalDateTime creationDate;

}
