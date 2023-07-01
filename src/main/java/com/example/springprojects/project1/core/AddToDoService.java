package com.example.springprojects.project1.core;



import com.example.springprojects.project1.core.validation.*;
import com.example.springprojects.project1.domain.ToDoEntity;
import com.example.springprojects.project1.dto.AddToDoRequest;
import com.example.springprojects.project1.dto.AddToDoResponse;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddToDoService {

    private RepositoryJPA repository;

    public AddToDoService(RepositoryJPA repository) {
        this.repository = repository;
    }

    ArrayList<ValidationRule> validationRuleList = new ArrayList<>();

    private ValidationService validationService = new ValidationService(validationRuleList);


public AddToDoResponse add(AddToDoRequest request) {
//    validationRuleList.clear();
//    validationRuleList.add(new ToDoNameNullValidationRule());
//    validationRuleList.add(new ToDoNameMinLengthValidationRule());
//    validationRuleList.add(new ToDoNameMaxLengthValidationRule());
//    validationRuleList.add(new ToDoDescriptionNullValidationRule());
//    validationRuleList.add(new ToDoDescriptionMaxLengthValidationRule());

    System.out.println("Received request " + request);
    var validationResult = validationService.validate(request);
    if (!validationResult.isEmpty()) {
        System.out.println("Validation failed, errors : " + validationResult);
        var response = new AddToDoResponse();
        response.setErrors(validationResult);
        return response;
    }

    var entity = convert(request);
    var createdEntity = repository.save(entity);
    System.out.println("Successfully saved: " + createdEntity);
    var response = new AddToDoResponse();
    response.setCreatedToDoId(createdEntity.getId());
    System.out.println("Sending response: " + response);
    return response;

}

private ToDoEntity convert(AddToDoRequest request) {
    ToDoEntity entity = new ToDoEntity();
    entity.setName(request.getName());
    entity.setDescription(request.getDescription());
    return entity;
}
}
