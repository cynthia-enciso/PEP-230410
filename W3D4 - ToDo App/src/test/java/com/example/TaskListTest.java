package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.models.Task;
import com.example.models.TaskList;

public class TaskListTest {
    
    private final TaskList taskList = new TaskList();
    
    // test create task
    @Test // positive test, all should go well!
    public void test_createTask_adds_task_to_list() {
        // arrange
        Task taskToAdd = new Task("Powerwash driveway", "only if weather permits.");

        // act
        boolean result = taskList.createTask(taskToAdd.getName(), taskToAdd.getDescription());

        // assert
        assertEquals(true, result);
    }

    @Test // negative test, it should fail appropriately!
    public void test_createTask_fails_because_name_is_whitespace() {
        assertThrows(IllegalArgumentException.class,
        () -> taskList.createTask(" ", "only if weather permits."));
    }

    @Test
    public void test_createTask_fails_because_description_is_whitespace() {
        assertThrows(IllegalArgumentException.class,
        () -> taskList.createTask("Powerwash driveway", " "));
    }

    @Test
    public void test_createTask_fails_because_name_has_no_characters() {
        assertThrows(IllegalArgumentException.class,
        () -> taskList.createTask("", "only if weather permits."));
    }

    @Test
    public void test_createTask_fails_because_description_has_no_characters() {
        assertThrows(IllegalArgumentException.class,
        () -> taskList.createTask("Powerwash driveway", ""));
    }

    // test remove task
    @Test
    public void test_removeTask_returns_true() {
        // arrange
        Task task = new Task("Cook dinner", "blackened salmon with rice and broccoli");
        taskList.createTask(task.getName(), task.getDescription());

        // act and assert
        assertTrue(taskList.removeTask(task));
    }

    @Test
    public void test_removeTask_returns_false() {
        Task taskNotInList = new Task("Bathe cat", "wear thick gloves!");
        assertFalse(taskList.removeTask(taskNotInList));
    }

    // test tasklist toString
    @Test
    public void test_toString_contains_correct_task_name() {
        // arrange
        taskList.setTasks(new ArrayList<>());
        taskList.getTasks().add(new Task("task1", "notes1"));

        assertTrue(taskList.toString().contains("task1"));
    }

}
