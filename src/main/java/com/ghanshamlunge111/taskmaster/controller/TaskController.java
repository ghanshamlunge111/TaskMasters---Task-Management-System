package com.ghanshamlunge111.taskmaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ghanshamlunge111.taskmaster.entity.Task;
import com.ghanshamlunge111.taskmaster.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;

	@PostMapping("/tasks/createNew")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task createdTask = taskService.createTask(task);
		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}

	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<Task> modifyTask(@PathVariable Long taskId,@RequestBody Task task) {
		Task updatedTask = taskService.updateTask(taskId, task);
		return updatedTask != null ?
				new ResponseEntity<>(updatedTask, HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/tasks")
	public String getAllTasks(Model model){
		model.addAttribute("tasks",taskService.getAllTasks());
		//System.out.println(model.toString());
		return "tasks";
	}

	/*
	 * @GetMapping("/tasks/{taskId}") public ResponseEntity<Task>
	 * getTaskById(@PathVariable Long taskId) { Optional<Task> getTask =
	 * taskService.getTaskById(taskId); return getTask.map(value -> new
	 * ResponseEntity<>(value, HttpStatus.OK)) .orElseGet(() -> new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND)); }
	 */
	
	@GetMapping("/tasks/{taskId}")
	public String getTaskById(@PathVariable Long taskId, Model model) {
		model.addAttribute("task",taskService.getTaskById(taskId));
		return "task";
	}
}
