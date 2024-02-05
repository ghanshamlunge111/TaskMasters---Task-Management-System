package com.ghanshamlunge111.taskmaster.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghanshamlunge111.taskmaster.entity.Task;
import com.ghanshamlunge111.taskmaster.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public Task createTask(Task task) {
		task.setReportedOn(LocalDate.now());
		return taskRepository.save(task);
	}

	public Task updateTask(Long id, Task task) {
		if (taskRepository.existsById(id)) {
			task.setTaskId(id);
			task.setReportedOn(LocalDate.now());
			return taskRepository.save(task);
		} else {
			// Handle not found scenario
			return null;
		}
	}

	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	public Optional<Task> getTaskById(Long taskId) {
		if (taskRepository.existsById(taskId)) {

			return taskRepository.findById(taskId);
		} else {
			// Handle not found scenario
			return null;
		}
	}
}
