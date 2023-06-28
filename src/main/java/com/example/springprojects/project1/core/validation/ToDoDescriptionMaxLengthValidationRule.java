package com.example.springprojects.project1.core.validation;


import com.example.springprojects.project1.dto.AddToDoRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoDescriptionMaxLengthValidationRule implements ValidationRule{
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getDescription().length() > 20) {
            throw new ValidationException("ToDo description length must be " +
                    "less that 20 but actual description length is " +
                    request.getDescription().length());
        }
    }
}
