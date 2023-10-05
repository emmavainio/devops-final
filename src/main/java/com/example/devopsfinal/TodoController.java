package com.example.devopsfinal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The controller class for managing todo tasks.
 */
@RestController
@RequestMapping("/api")
public class TodoController {
    /**
     * Autowired service for managing todo tasks.
     */
    @Autowired
    private TodoService todoService;

    /**
     * Adds a new task.
     *
     * @param task The task to be added.
     * @return A ResponseEntity with a message indicating the task has been added.
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> addTask2(@RequestParam String task) {
        todoService.addTask(task);
        return ResponseEntity.ok("Task added!");
    }

    /**
     * Modifies an existing task.
     *
     * @param task  The modified task content.
     * @param index The index of the task to be modified.
     * @return A ResponseEntity with a message indicating the task has been modified.
     */
    @PostMapping("/modify")
    public ResponseEntity<String> modifyTask(String task, int index) {
        todoService.modifyTask(task, index);
        return ResponseEntity.ok("Task modified!");
    }

    /**
     * Deletes a task by index.
     *
     * @param index The index of the task to be deleted.
     * @return A ResponseEntity with a message indicating the task has been deleted.
     */
    @PostMapping("/delete")
    public ResponseEntity<String> deleteTask(@RequestParam int index) {
        todoService.deleteTask(index);
        return ResponseEntity.ok("Task deleted!");
    }

    /**
     * Lists all available tasks.
     *
     * @return A list of task strings.
     */
    @GetMapping("/list")
    public List<String> listTasks() {
        return todoService.listTasks();
    }

    /**
     * Empties the task list.
     */
    @GetMapping("/emptyList")
    public void emptyList() {
        todoService.emptyList();
    }


}