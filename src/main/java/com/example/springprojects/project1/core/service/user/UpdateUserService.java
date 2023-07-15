package com.example.springprojects.project1.core.service.user;

import com.example.springprojects.project1.core.util.Converters;
import com.example.springprojects.project1.domain.User;
import com.example.springprojects.project1.dto.user.AddUpdateUserResponse;
import com.example.springprojects.project1.dto.user.AddUserRequest;
import com.example.springprojects.project1.dto.user.UpdateUserRequest;
import com.example.springprojects.project1.repository.newVar.UserRepositoryJPA;
import jakarta.persistence.Convert;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Data
@AllArgsConstructor
public class UpdateUserService {

    private final UserRepositoryJPA repositoryJPA;

    public AddUpdateUserResponse updateUser(UpdateUserRequest request) {
        User user = repositoryJPA.findByAccessKey(request.getAccessKey())
                .orElseThrow(() -> new ValidationException("User not found"));

        user = updateFieldsInUser(user,request);
        repositoryJPA.save(user);
        return new AddUpdateUserResponse(user.getId(), user.getUserName(), user.getAccessKey(), new ArrayList<>());
    }

    private User updateFieldsInUser(User user, UpdateUserRequest request) {
        if (check(request.getNewPassword())) {user.setPassword(request.getNewPassword());}
        if (check(request.getNewEmail())) {user.setEmail(request.getNewEmail());}

        user.setLastVisit(LocalDateTime.now());
        user.setAccessKey(createAccessKey(request));
        return user;
    }

    private String createAccessKey(UpdateUserRequest request) {
        return (request.getUsername()+request.getNewPassword()+request.getNewEmail()).hashCode()+"";
    }


    private boolean check (String criteria) {
        return (criteria != null) && (!criteria.equals("")) && (!criteria.isBlank());
    }
}
