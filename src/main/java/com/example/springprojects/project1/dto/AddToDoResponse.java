package com.example.springprojects.project1.dto;



import com.example.springprojects.project1.core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddToDoResponse {
    private Integer createdToDoId;
    private List<CoreError> errors;

}
