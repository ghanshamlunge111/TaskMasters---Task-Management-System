package com.ghanshamlunge111.taskmaster.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "task_id")
	private long taskId;
	
	@Column(name = "task_type")
	private String taskType;
	
	@Column(name = "reported_by")
	private String reportedBy;
	
	@Column(name = "assigned_to")
	private String assignedTo;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "reported_on")
	private LocalDate reportedOn;
	
	@Column(name = "resolved_on")
	private LocalDate resolvedOn;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getReportedOn() {
		return reportedOn;
	}

	public void setReportedOn(LocalDate reportedOn) {
		this.reportedOn = reportedOn;
	}

	public LocalDate getResolvedOn() {
		return resolvedOn;
	}

	public void setResolvedOn(LocalDate resolvedOn) {
		this.resolvedOn = resolvedOn;
	}
}
