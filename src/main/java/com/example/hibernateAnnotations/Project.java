package com.example.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="description")
	private String description;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project(Long id, String projectName, String description) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.description = description;
	}

	public Project(String projectName, String description) {
		super();
		this.projectName = projectName;
		this.description = description;
	}

	public Project() {

	}

}
