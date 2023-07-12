package com.example.springprojects.project1.dto.user;

import com.example.springprojects.project1.core.validation.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddUpdateUserResponse {
    private Integer id;
    private String name;
    private String accessKey;
    private List<CoreError> errors;

}
