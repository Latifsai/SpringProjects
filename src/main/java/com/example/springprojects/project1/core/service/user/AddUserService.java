package com.example.springprojects.project1.core.service.user;

import com.example.springprojects.project1.core.util.Converters;
import com.example.springprojects.project1.domain.User;
import com.example.springprojects.project1.dto.user.AddUpdateUserResponse;
import com.example.springprojects.project1.dto.user.AddUserRequest;
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
public class AddUserService {

    private final UserRepositoryJPA repository;
    private final Converters converters;

    public AddUpdateUserResponse addUser(AddUserRequest request) {

        if (checkNewUser(request)) {

            User user = converters.convertUserRequestToEntity(request);
            user.setLastVisit(LocalDateTime.now());
            user.setAccessKey(createAccessKey(request));
            user = repository.save(user);
            return new AddUpdateUserResponse(user.getId(),
                    user.getUserName(), user.getAccessKey(), new ArrayList<>());
        } else {
            throw new ValidationException("This user is already exist");
        }

    }

    private String createAccessKey(AddUserRequest request) {
        return (request.getUsername()+request.getPassword()+request.getEmail()).hashCode()+"";
    }

    private boolean checkNewUser(AddUserRequest request) {
        return repository.findByUserNameAndEmail(
                request.getUsername(), request.getEmail()).isEmpty();
    }
}
