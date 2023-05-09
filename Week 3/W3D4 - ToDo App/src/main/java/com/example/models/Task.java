package com.example.models;
import java.util.Objects;

public class Task {

    // state
    private String name;
    private String description;
    private boolean isComplete; // false by default

    // initalization
    public Task() {} // use just for testing

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // once state and constructors created, think of methods that need to happen
    // behavior
    public boolean toggleCompletion() {
        return isComplete = !isComplete;
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsComplete() {
        return this.isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && isComplete == task.isComplete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, isComplete);
    }

    @Override
    public String toString() {
        return "Task: " + this.name + " | Description: " + this.description;
    }

}
