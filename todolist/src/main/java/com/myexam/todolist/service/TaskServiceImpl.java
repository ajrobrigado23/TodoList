package com.myexam.todolist.service;

import com.myexam.todolist.dao.TaskDAO;
import com.myexam.todolist.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO){
        this.taskDAO = taskDAO;
    }

    // Create a new task
    @Override
    @Transactional
    public void createTask(Task task) {
        this.taskDAO.createTask(task);
    }

    @Override
    public List<Task> findAllTasks(){

        return this.taskDAO.findAllTasks();
    }

    // Update a task
    @Override
    public Task findSingleTaskId(int id) {
        return this.taskDAO.findSingleTaskId(id);
    }

    @Override
    @Transactional
    public void updateTask(int theId, Task task) {

        Task tempTask = findSingleTaskId(task.getId());

        tempTask.setTaskDescription(task.getTaskDescription());

        this.taskDAO.updateTask(tempTask);
    }

    @Override
    @Transactional
    public void deleteTaskById(int theId) {
        this.taskDAO.deleteTaskById(theId);
    }
}
