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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_mm")
public class QuestionMM {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="question")
	private String question;
	
	@ManyToMany(targetEntity=com.example.hibernateAnnotations.AnswersMM.class, cascade = CascadeType.ALL)
	@JoinTable(name="question_answers", joinColumns = {
	@JoinColumn(name="question_id")},
	inverseJoinColumns = {@JoinColumn(name = "answers_id")})
	private List<AnswersMM> answers;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<AnswersMM> getAnswers() {
		return answers;
	}


	public void setAnswers(List<AnswersMM> answers) {
		this.answers = answers;
	}

	

	public QuestionMM(String question) {
		super();
		this.question = question;
	}


	public QuestionMM(String question, List<AnswersMM> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}
	
	public QuestionMM() {
		
		
	}
	

}
