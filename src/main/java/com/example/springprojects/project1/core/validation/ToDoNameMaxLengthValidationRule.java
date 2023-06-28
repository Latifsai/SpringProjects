package com.example.springprojects.project1.core.validation;


import com.example.springprojects.project1.dto.AddToDoRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoNameMaxLengthValidationRule implements ValidationRule{
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName().length() > 10) {
            throw new ValidationException("ToDo name length must be " +
                    "less that 10 but actual name length is " +
                    request.getName().length());
        }
    }
}
