package com.ghanshamlunge111.taskmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ghanshamlunge111.taskmaster.entity.Task;
import com.ghanshamlunge111.taskmaster.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/tasks/createNew")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "new_task"; //returning thymeleaf template
    }

	@PostMapping("/tasks/new")
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks/" + task.getTaskId();
    }
	
	/*
	 * @PostMapping("/tasks/createNew") public ResponseEntity<Task>
	 * createTask(@RequestBody Task task) { Task createdTask =
	 * taskService.createTask(task); return new ResponseEntity<>(createdTask,
	 * HttpStatus.CREATED); }
	 */

	@GetMapping("/tasks/{taskId}/update")
    public String showEditForm(@PathVariable Long taskId, Model model) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", task);
        return "update_task"; //returning thymeleaf template
    }

    @PostMapping("/tasks/{taskId}/update")
    public String updateTask(@PathVariable Long taskId, @ModelAttribute Task updatedTask) {
        Task existingTask = taskService.getTaskById(taskId);
        if (existingTask != null) {
            existingTask.setTaskType(updatedTask.getTaskType());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setReportedBy(updatedTask.getReportedBy());
            existingTask.setAssignedTo(updatedTask.getAssignedTo());
            existingTask.setComments(updatedTask.getComments());
            existingTask.setReportedOn(updatedTask.getReportedOn());
            existingTask.setResolvedOn(updatedTask.getResolvedOn());
            taskService.updateTask(taskId, existingTask);
            return "redirect:/tasks/" + taskId;
        } else {
            return "redirect:/tasks";
        }
    }
	
	/*
	 * @PutMapping("/tasks/{taskId}") public ResponseEntity<Task>
	 * modifyTask(@PathVariable Long taskId,@RequestBody Task task) { Task
	 * updatedTask = taskService.updateTask(taskId, task); return updatedTask !=
	 * null ? new ResponseEntity<>(updatedTask, HttpStatus.OK) : new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 */

	@GetMapping("/tasks")
	public String getAllTasks(Model model){
		model.addAttribute("tasks",taskService.getAllTasks());
		return "tasks"; //returning thymeleaf template
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
		return "task_detail"; //returning thymeleaf template
	}
}
