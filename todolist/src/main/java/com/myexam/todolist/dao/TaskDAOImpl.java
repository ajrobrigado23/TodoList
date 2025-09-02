package com.myexam.todolist.dao;

import com.myexam.todolist.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    private final EntityManager entityManager;

    @Autowired
    public TaskDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createTask(Task task) {
        this.entityManager.persist(task);
    }

    @Override
    public List<Task> findAllTasks() {

        // create a query
        TypedQuery<Task> query = this.entityManager.createQuery("SELECT t FROM Task t", Task.class);

        // execute the query and return the list of task
        return query.getResultList();
    }

    @Override
    public Task findSingleTaskId(int theId) {

        // create query
        TypedQuery<Task> query = this.entityManager.createQuery
                ("SELECT t FROM Task t " +
                    "WHERE t.id = :id ", Task.class);

        // execute the query
        query.setParameter("id", theId);

        // return query
        return query.getSingleResult();
    }

    @Override
    public void updateTask(Task task){
        this.entityManager.merge(task);
    }

    @Override
    public void deleteTaskById(int theId){

        Task tempTask = this.entityManager.find(Task.class, theId);

        this.entityManager.remove(tempTask);
    }
}
