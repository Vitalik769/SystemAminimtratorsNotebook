package com.example.Notebook.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NotebookController {

    @GetMapping("/")
    public String greeting( Model model) {
        model.addAttribute("title", "Teacher");
        return "index";
    }

}