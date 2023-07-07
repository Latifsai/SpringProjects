package com.example.springprojects.project1.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20")
    @NotBlank(message = "Must be not blank!")
    @NotEmpty(message = "Must not be Empty!")
    private String name;
    @Size(min = 5, max = 40, message = "Description must be between 5 and 40")
    @NotBlank(message = "Must be not blank!")
    @NotEmpty(message = "Must not be Empty!")
    private String description;
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "to_do_author_id")
    private User toDoAuthor;
}
