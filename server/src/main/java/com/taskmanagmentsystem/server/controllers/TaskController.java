package com.taskmanagmentsystem.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagmentsystem.server.entity.TaskEntity;
import com.taskmanagmentsystem.server.service.TaskService;




@RestController
@CrossOrigin
public class TaskController {
	
	@Autowired
	private TaskService service;

	@GetMapping("/tasks")
	public ResponseEntity<List<TaskEntity>> getTasks() {
		
		return new ResponseEntity<>(service.getAllTask(),HttpStatus.OK);
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<TaskEntity> saveTaskDetails(@RequestBody TaskEntity taskEntity) {

		Integer taskId = service.addtask(taskEntity);

		if (taskId != null) {
			return new ResponseEntity<TaskEntity>(service.getTaskById(taskId), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<TaskEntity>(new TaskEntity(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<TaskEntity> getTaskById(@PathVariable Integer taskId) {
		TaskEntity taskEntity = service.getTaskById(taskId);
		
		if(taskEntity==null) {
			new ResponseEntity<TaskEntity>(taskEntity,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TaskEntity>(taskEntity,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("tasks/{taskId}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Integer taskId, @RequestBody TaskEntity updatedTask) {
        TaskEntity updateTask = service.updateTask(taskId, updatedTask);
        return new ResponseEntity<TaskEntity>(updateTask,HttpStatus.OK);
    }

	@DeleteMapping("tasks/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) {
		service.deleteTask(taskId);
		return new ResponseEntity<String>("Task deleted ",HttpStatus.OK);
	}
	
	
	
	
}
