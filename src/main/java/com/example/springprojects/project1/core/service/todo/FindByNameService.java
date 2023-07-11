package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.domain.ToDo;
import com.example.springprojects.project1.dto.todo.ToDoDTO;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FindByNameService {
    private final RepositoryJPA repository;

    // сделать рефоторинш медота сделать его красивым и грамотным
    public List<ToDoDTO> findByName(String name) {
        return repository.findByName(name).stream()
                .map(this::convert)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.isEmpty()){
                        throw new IllegalArgumentException("Todo with name " + name + " is not found!");
                    }
                    return list;
                }));
    }


    private ToDoDTO convert(ToDo entity) {
        return new ToDoDTO(entity.getName(), entity.getDescription(), entity.getCreationDate());
    }

}
