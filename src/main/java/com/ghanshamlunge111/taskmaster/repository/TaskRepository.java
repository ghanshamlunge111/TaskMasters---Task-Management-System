package com.ghanshamlunge111.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghanshamlunge111.taskmaster.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
