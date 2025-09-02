package com.myexam.todolist.dao;

import com.myexam.todolist.entity.Task;

import java.util.List;

public interface TaskDAO {

    void createTask(Task task);

    List<Task> findAllTasks();

    Task findSingleTaskId(int id);

    // update the task
    void updateTask(Task task);

    // delete the task
    void deleteTaskById(int theId);
}
