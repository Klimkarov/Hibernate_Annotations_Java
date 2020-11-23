package com.example.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")

public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="department_name")
	private String deptName;
	
	@Column(name="number_employees")
	private Integer numEmployees;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)  
        @JoinColumn(name = "project_id", nullable = false)   
	private Project project;                             
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, String deptName, Integer numEmployees) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.numEmployees = numEmployees;
		this.project = project;
	}
	
	public Department( String deptName, Integer numEmployees, Project project) { 
		super();                                                                
		this.deptName = deptName;
		this.numEmployees = numEmployees;
		this.project = project;
	}
	
	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getNumEmployees() {
		return numEmployees;
	}

	public void setNumEmployees(Integer numEmployees) {
		this.numEmployees = numEmployees;
	}
	


}
