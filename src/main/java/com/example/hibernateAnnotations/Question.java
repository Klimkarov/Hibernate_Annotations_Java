package com.example.hibernateAnnotations;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "question")
	private String ques;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private List<Answers> answers;
	
	
	

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public Question(Long id, String ques) {
		super();
		this.id = id;
		this.ques = ques;
	}

	public Question(String ques) {
		super();
		this.ques = ques;
	}

	public Question() {

	}

}
