package com.example.springprojects.project1.core.validation;


import com.example.springprojects.project1.dto.AddToDoRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoNameMinLengthValidationRule implements ValidationRule{
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName().length() < 3) {
            throw new ValidationException("ToDo name length must be " +
                    "greater that 3 but actual name length is " +
                    request.getName().length());
        }
    }
}
