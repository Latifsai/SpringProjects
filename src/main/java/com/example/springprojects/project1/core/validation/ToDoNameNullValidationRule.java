package com.example.springprojects.project1.core.validation;


import com.example.springprojects.project1.dto.AddToDoRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoNameNullValidationRule implements ValidationRule{
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("ToDo name must not be null");
        }
    }
}
