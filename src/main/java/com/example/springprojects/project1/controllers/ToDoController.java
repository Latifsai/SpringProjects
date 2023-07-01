package com.example.springprojects.project1.controllers;

import com.example.springprojects.project1.core.AddToDoService;
import com.example.springprojects.project1.core.FindAllToDoService;
import com.example.springprojects.project1.core.FindByIService;
import com.example.springprojects.project1.core.UpdateTodoService;
import com.example.springprojects.project1.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class ToDoController {

    private final AddToDoService addToDoService;
    private final FindAllToDoService findAllToDoService;
    private final FindByIService findByIService;
    private final UpdateTodoService updateTodoService;

    @PostMapping()
    public AddToDoResponse add(@RequestBody AddToDoRequest request) {
        return addToDoService.add(request);
    }

    @GetMapping
    public FindAllToDoResponse findAll() {
        return findAllToDoService.findAll();
    }

    @GetMapping(value = "/{idPath}")
    public ToDoDTO findByID(@PathVariable("idPath") Integer id) {
        return findByIService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody UpdateTodoRequest request) {
        request.setId(id);
        updateTodoService.update(request);
    }


}
