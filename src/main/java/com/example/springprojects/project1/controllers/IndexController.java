package com.example.springprojects.project1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/ui")
    public String getIndex(@RequestParam(value = "name",
            defaultValue = "World!", required = false)
                           String nameVar, Model model) {
        model.addAttribute("name", nameVar);
        return "index";
    }


}
