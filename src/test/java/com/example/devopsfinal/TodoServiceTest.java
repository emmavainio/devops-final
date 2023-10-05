package com.example.devopsfinal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * A set of unit tests for the TodoService class.
 */
public class TodoServiceTest {


    private final TodoService todoService = new TodoService(new ArrayList<>());

    /**
     * Test the 'addTaskTest' method, which should add a task to the list.
     */
    @Test
    public void addTaskTest_ShouldAddTask() {
        todoService.addTask("test");
        Assertions.assertEquals(todoService.listTasks().get(0), "test");
    }

    /**
     * Test the 'modifyTaskTest' method, which should modify a task in the list.
     */
    @Test
    public void modifyTaskTest_ShouldModifyTask() {
        todoService.addTask("test");
        todoService.modifyTask("test2", 0);
        Assertions.assertEquals(todoService.listTasks().get(0), "test2");
    }

    /**
     * Test the 'deleteTaskTest' method, which should delete a task from the list.
     */
    @Test
    public void deleteTaskTest_ShouldDeleteTask() {
        todoService.addTask("test");
        todoService.deleteTask(0);
        Assertions.assertEquals(todoService.listTasks().size(), 0);
    }

    /**
     * Test the 'emptyListTest' method, which should empty the list.
     */
    @Test
    public void emptyListTest_shouldEmptyList() {
        todoService.addTask("test");
        todoService.emptyList();
        Assertions.assertEquals(todoService.listTasks().size(), 0);
    }

    /**
     * Test the 'listTasks' method, which should return a list of tasks.
     */
    @Test
    public void listTasks_ShouldReturnList() {
        todoService.addTask("test");
        Assertions.assertEquals(todoService.listTasks().get(0), "test");
    }
}
