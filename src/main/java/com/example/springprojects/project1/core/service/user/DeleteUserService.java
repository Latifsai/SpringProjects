package com.example.springprojects.project1.core.service.user;

import com.example.springprojects.project1.core.util.Converters;
import com.example.springprojects.project1.domain.User;
import com.example.springprojects.project1.dto.user.AddUpdateUserResponse;
import com.example.springprojects.project1.dto.user.DeleteUserRequest;
import com.example.springprojects.project1.dto.user.DeleteUserResponse;
import com.example.springprojects.project1.dto.user.UpdateUserRequest;
import com.example.springprojects.project1.repository.newVar.UserRepositoryJPA;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Data
@AllArgsConstructor
public class DeleteUserService {

    private final UserRepositoryJPA repositoryJPA;

    public final Converters converters;

    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        User user = repositoryJPA.findByUserNameAndAccessKey
                        (request.getName(), request.getAccessKey())
                .orElseThrow(() -> new ValidationException("User not found"));

        repositoryJPA.delete(user);
        return new DeleteUserResponse(user.getId(), user.getUserName(), new ArrayList<>());
    }

}
