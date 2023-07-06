package com.example.springprojects.project1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 4, max = 8, message = "Name length must be between 4 and 8!")
    @NotNull(message = "Name must not be null!")
    @Pattern(regexp = "^[a-zA-z][a-zA-z0-9]*$", message = " Incorrect name format! ")
    private String userName;
    private String password;
    @NotNull
    @Email
    private String email;
    private String accessKey;
    private LocalDateTime lastVisit;

}
