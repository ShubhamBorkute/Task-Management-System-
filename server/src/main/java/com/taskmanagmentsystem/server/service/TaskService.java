package com.taskmanagmentsystem.server.service;

import java.util.List;

import com.taskmanagmentsystem.server.entity.TaskEntity;

public interface TaskService {

	public List<TaskEntity> getAllTask();
	
	public Integer addtask(TaskEntity taskEntity);
	
	public TaskEntity updateTask(Integer taskId, TaskEntity updatedTask);
	
	public TaskEntity getTaskById(Integer taskId);
	
	public Boolean deleteTask(Integer taskId);

	TaskEntity getTask(TaskEntity taskEntity);
}
