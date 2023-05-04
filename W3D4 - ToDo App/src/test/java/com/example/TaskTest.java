package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// 1. import class you are testing
import com.example.models.Task;

public class TaskTest {

    private final Task task = new Task();

    // test toggleCompletion
    @Test
    public void test_toggleCompletion_returns_true() {
        // set task to not completed by setting isComplete to false
        task.setIsComplete(false);
        
        // toggling should return true (that it is complete)
        assertEquals(true, task.toggleCompletion());

    }

    @Test
    public void test_toggleCompletion_returns_false() {
        // set task to completed by setting isComplete to true
        task.setIsComplete(true);

        // toggling should return false (that it is now uncomplete)
        assertEquals(false, task.toggleCompletion());
    }

}
