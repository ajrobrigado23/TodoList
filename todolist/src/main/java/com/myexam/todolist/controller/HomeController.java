package com.myexam.todolist.controller;

import com.myexam.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final TaskService taskService;

    @Autowired
    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Show the home page
    @GetMapping("/homepage")
    public String showHome(Model theModel) {

        theModel.addAttribute("task", taskService.findAllTasks());

        return "home";
    }
}
