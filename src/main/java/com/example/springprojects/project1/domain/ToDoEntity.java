package com.example.springprojects.project1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 3,max = 20, message = "Name must be between 3 and 20")
    @NotBlank(message = "Must be not blank!")
    @NotEmpty(message = "Must not be Empty!")
    private String name;
    @Size(min = 5,max = 40, message = "Description must be between 5 and 40")
    @NotBlank(message = "Must be not blank!")
    @NotEmpty(message = "Must not be Empty!")
    private String description;

}
