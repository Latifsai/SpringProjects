package com.example.springprojects.project1.core.validation;


import com.example.springprojects.project1.dto.AddToDoRequest;

public interface ValidationRule {

    void validate(AddToDoRequest request);

}
