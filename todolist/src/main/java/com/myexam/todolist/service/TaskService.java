package com.myexam.todolist.service;

import com.myexam.todolist.entity.Task;

import java.util.List;

public interface TaskService {

    void createTask(Task task);

    List<Task> findAllTasks();

    Task findSingleTaskId(int id);

    void updateTask(int theId, Task task);

    void deleteTaskById(int theId);
}
