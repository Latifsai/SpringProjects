package com.example.springprojects.project1.core.validation;


import com.example.springprojects.project1.dto.AddToDoRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoDescriptionNullValidationRule implements ValidationRule{
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getDescription() == null) {
            throw new ValidationException("ToDo description must not be null");
        }
    }
}
