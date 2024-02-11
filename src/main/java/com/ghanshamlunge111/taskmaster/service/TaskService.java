package com.ghanshamlunge111.taskmaster.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghanshamlunge111.taskmaster.entity.Task;
import com.ghanshamlunge111.taskmaster.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Long id, Task task) {
		if (taskRepository.existsById(id)) {
			task.setTaskId(id);
			return taskRepository.save(task);
		} else {
			return null;
		}
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAllByOrderByTaskIdDesc();
	}

	public Task getTaskById(Long taskId) {
		return taskRepository.findById(taskId).orElse(null);
	}
}
