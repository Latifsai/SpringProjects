package com.example.springprojects.project1.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FindAllUsersRequest {

    private String name;
    private String accessKey;
}
