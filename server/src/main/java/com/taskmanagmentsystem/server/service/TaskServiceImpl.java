package com.taskmanagmentsystem.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.taskmanagmentsystem.server.entity.TaskEntity;
import com.taskmanagmentsystem.server.exception.ResourceNotFoundException;
import com.taskmanagmentsystem.server.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public List<TaskEntity> getAllTask() {
		
		return taskRepo.findAll();
	}

	@Override
	public Integer addtask(TaskEntity taskEntity) {
		
		return taskRepo.save(taskEntity).getTaskId();
	}

	@Override
	public TaskEntity getTaskById(Integer taskId) {
		
		return taskRepo.getById(taskId);
	}

	@Override
	public Boolean deleteTask(Integer taskId) {
		
		try {
            taskRepo.deleteById(taskId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Task not found with id: " + taskId);
        }
	}

	public TaskEntity updateTask(Integer taskId, TaskEntity updatedTask) {
	    TaskEntity existingTask = taskRepo.findById(taskId)
	            .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

	    existingTask.setTitle(updatedTask.getTitle());
	    existingTask.setDescription(updatedTask.getDescription());
	    existingTask.setStatus(updatedTask.getStatus());

	    return taskRepo.save(existingTask);
	}
	@Override
	public TaskEntity getTask(TaskEntity taskEntity) {
		
		return taskRepo.findById(taskEntity.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskEntity.getTaskId()));
	}

}
