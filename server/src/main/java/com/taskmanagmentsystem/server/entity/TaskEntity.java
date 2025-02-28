package com.taskmanagmentsystem.server.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="task")
@Data
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	private String title;
	
	private String description;
	
	private String status;
	
	@CreationTimestamp
	@Column(name="TaskCreatedDate",updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="TaskupdatedDate",insertable = false)
	private LocalDate updateddate;
	
	//private String action;
}
