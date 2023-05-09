package com.example.models;

import java.util.ArrayList;

public class TaskList {
    
    // state
    private ArrayList<Task> tasks;
    
    // initialization
    public TaskList() {
        tasks = new ArrayList<>();
    }

    // behavior
    public boolean createTask(String name, String description) {
        // validation checks
        if (name.equals("") || description.equals("")) {
            throw new IllegalArgumentException("Invalid input: you must enter at least one character.");
        } else if (name.equals(" ") || description.equals(" ")) {
            throw new IllegalArgumentException("Invalid input: whitespace only is not allowed.");
        }

        Task taskToAdd = new Task(name, description);
        return tasks.add(taskToAdd);
    }

    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    public String toString() {
        String list = "To Do List:";
        for (Task task : tasks) {
            list += "\n" + task.toString();
        }
        
        return list;
    }

    // getters and setters

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(ArrayList<Task> taskList) {
        this.tasks = taskList;
    }

}
