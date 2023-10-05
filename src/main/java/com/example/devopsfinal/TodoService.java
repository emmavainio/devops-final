package com.example.devopsfinal;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service class for managing todo tasks.
 */
@Service
public class TodoService {
    /**
     * The list that stores todo tasks.
     */
    private List<String> taskList;

    /**
     * Constructor for initializing the TodoService with a list of tasks.
     *
     * @param taskList The list of tasks to be managed.
     */
    public TodoService(List<String> taskList) {
        this.taskList = taskList;
    }

    /**
     * Adds a new task to the task list.
     *
     * @param task The task to be added.
     */
    public void addTask(String task) {
        taskList.add(task);

    }

    /**
     * Modifies an existing task at the specified index.
     *
     * @param task  The modified task content.
     * @param index The index of the task to be modified.
     */
    public void modifyTask(String task, int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.set(index, task);
        }
    }

    /**
     * Deletes a task at the specified index.
     *
     * @param index The index of the task to be deleted.
     */
    public void deleteTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
        }
    }

    /**
     * Retrieves a list of all available tasks.
     *
     * @return A list of task strings.
     */
    public List<String> listTasks() {
        return taskList;
    }

    /**
     * Clears the task list, making it empty.
     */
    public void emptyList() {
        taskList.clear();
    }
}
