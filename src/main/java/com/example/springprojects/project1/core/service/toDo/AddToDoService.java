package com.example.springprojects.project1.core.service.toDo;

import com.example.springprojects.project1.core.util.Converters;
import com.example.springprojects.project1.domain.User;
import com.example.springprojects.project1.dto.todo.AddToDoRequest;
import com.example.springprojects.project1.dto.todo.AddUpdateToDoResponse;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import com.example.springprojects.project1.repository.newVar.UserRepositoryJPA;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddToDoService {
    private final RepositoryJPA repositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final Converters converters;

    public AddUpdateToDoResponse addToDo(AddToDoRequest request) {
        Optional<User> user = checkUserAccessKey(request);
        if (user.isPresent()) {
            var newToDo = converters.convertToDoRequestToEntity(request);
            newToDo.setCreationDate(LocalDateTime.now());
            newToDo.setToDoAuthor(user.get());
            repositoryJPA.save(newToDo);
            return new AddUpdateToDoResponse(newToDo.getId(), new ArrayList<>());
        } else {
            throw new ValidationException("AccessKey is not exist!");
        }


    }

    private Optional<User> checkUserAccessKey(AddToDoRequest request) {
        return userRepositoryJPA.findByAccessKey(request.getAccessKey());
    }
}
