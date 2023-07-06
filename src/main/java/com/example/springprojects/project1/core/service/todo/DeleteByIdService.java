package com.example.springprojects.project1.core.service.todo;

import com.example.springprojects.project1.dto.todo.DeleteByIDResponse;
import com.example.springprojects.project1.repository.newVar.RepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteByIdService {
    private RepositoryJPA repository;

    public DeleteByIDResponse deleteByID(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new DeleteByIDResponse(true);
        }
        return new DeleteByIDResponse(false);
    }
}
