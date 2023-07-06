package com.example.springprojects.project1.dto.todo;

import com.example.springprojects.project1.core.validation.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DeleteByIDResponse {
    private boolean isDeleted;
    List<CoreError> errors;

    public DeleteByIDResponse(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
