package com.example.springprojects.project1.controllers;

import com.example.springprojects.project1.core.AddToDoService;
import com.example.springprojects.project1.core.FindAllToDoService;
import com.example.springprojects.project1.dto.AddToDoRequest;
import com.example.springprojects.project1.dto.FindAllToDoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ToDoUIController {

    private final AddToDoService addToDoService;
    private final FindAllToDoService findAllToDoService;

    @GetMapping("/ui/addTodo")
    public String addToDoView(Model model) {
        model.addAttribute("todo", new AddToDoRequest());
        return "addToDo";
    }

    @PostMapping("/ui/addTodo")
    public String addToDo(@ModelAttribute AddToDoRequest request) {
        addToDoService.add(request);
        return "redirect:/ui/findAllTodo";
    }

    @GetMapping("/ui/findAllTodo")
    public String findAllToDo(Model model) {
        FindAllToDoResponse response = findAllToDoService.findAll();
        model.addAttribute("todos", response.getTodos());
        return "findAllToDo";
    }
}
