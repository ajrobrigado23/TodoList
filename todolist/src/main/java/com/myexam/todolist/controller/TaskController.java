package com.myexam.todolist.controller;

import com.myexam.todolist.entity.Task;
import com.myexam.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/showTaskForm")
    public String showTaskForm(Model theModel) {

        Task newTask = new Task();

        theModel.addAttribute("task", newTask);

        return "saveTaskForm";
    }

    @PostMapping("/saveTaskForm")
    public String saveTaskForm(@ModelAttribute("task") Task task) {

        this.taskService.createTask(task);

        return "redirect:/homepage";
    }

    @GetMapping("/updateTask")
    public String updateTask(@RequestParam("id") int id,
                             Model theModel) {

        // Find the task id
        theModel.addAttribute("updateTask", this.taskService.findSingleTaskId(id));

        return "/updateTaskForm";
    }

    @PostMapping("/saveUpdatedTask")
    public String saveUpdatedTask(@ModelAttribute Task task){

        this.taskService.updateTask(task.getId(), task);

        return "redirect:/homepage";
    }

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") int id) {

        this.taskService.deleteTaskById(id);

        return "redirect:/homepage";
    }
}
