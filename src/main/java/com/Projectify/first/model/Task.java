package com.Projectify.first.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Task {
	
	int taskId;
	
	
	int taskGroupId;
	
	Date createdAt;
	
	String taskName;
	
	int Position;
	
	String description;
	
	Date dueDate;
	
	Date completedAt;
	
	boolean hasTime;
	
	
	

}
