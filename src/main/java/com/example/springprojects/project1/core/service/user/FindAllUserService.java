package com.example.springprojects.project1.core.service.user;

import com.example.springprojects.project1.dto.todo.FindAllToDoResponse;
import com.example.springprojects.project1.dto.user.FindAllUsersRequest;
import com.example.springprojects.project1.dto.user.FindAllUsersResponse;
import com.example.springprojects.project1.repository.newVar.UserRepositoryJPA;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
@AllArgsConstructor
public class FindAllUserService {

    private final UserRepositoryJPA userRepositoryJPA;

    public FindAllUsersResponse findAllUsers(FindAllUsersRequest request){
        if (userRepositoryJPA.findByAccessKey(request.getAccessKey()).isPresent()) {
            return new FindAllUsersResponse(userRepositoryJPA.findAll(),
                    new ArrayList<>());
        }else {
            throw new ValidationException("Admin rights required!");
        }

    }

}
