package com.example.hibernateAnnotations;

import java.util.ArrayList;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {

// ManyToOne postavuvanje na site tri tabeli//
	static SessionFactory factory;

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Employee.class); // ne e vazen rasporedot na klasite
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Project.class);
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Department.class);
			cfg.configure();
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
// ------------------------------------------------------------------------------------------ //
	               //  ManyToOne //
			
			Project project = new Project("ProjectX", "Explination about the project");
			session.save(project);
			
			Department dept= new Department("DeptX", 11, project);
			session.save(dept);
			
			Date date = new Date(System.currentTimeMillis());
			Employee emp = new Employee("Sashko", "Klimkarov", 12321, date, dept);
			session.save(emp);
			session.close();
// ------------------------------------------------------------------------------------------ //	
//
//        
//	        
//			String hql = "SELECT e FROM Employee e Where e.id=: empid";
//			Query query = session.createQuery(hql); 
//		
//			List<Employee> result = query.setParameter("empid", 1).list(); 
//			System.out.println(result.get(0).getFirstName()); 
//			
//			Department d = result.get(0).getDepartment();
//			System.out.println(d.getDeptName());
//			
//			Project p = d.getProject();  
//			System.out.println(p.getProjectName());
//			
//			session.close();
// ------------------------------------------------------------------------------------------ //
//			// One to Many //
//			Configuration cfg = new Configuration();
//			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Question.class);
//			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Answers.class);
//			cfg.configure();
//			factory = cfg.configure().buildSessionFactory();
//			Session session = factory.openSession();
//			tx = session.beginTransaction();
//
//			// One to Many //
//
//			Question question = new Question("What is JAVA?");
//
//			List<Answers> answers = new ArrayList<Answers>();
//
//			Answers answer1 = new Answers("JAVA is prog lang", "Dimitar");
//			Answers answer2 = new Answers("JAVA is proggraming lang", "Tom");
//
//			answers.add(answer1);
//			answers.add(answer2);
//
//			question.setAnswers(answers);
//
//			// one-to-many relation is using session.persist //
//			session.persist(question);
//
//			tx.commit();
//			session.close();
// ----------------------------------------------------------------------------------------------			
//			// ManyToMany //
//			
//			Configuration cfg = new Configuration();
//			cfg.addAnnotatedClass(com.example.hibernateAnnotations.QuestionMM.class);
//			cfg.addAnnotatedClass(com.example.hibernateAnnotations.AnswersMM.class);
//			cfg.configure();
//			factory = cfg.configure().buildSessionFactory();
//			Session session = factory.openSession();
//			tx = session.beginTransaction();
//
//			QuestionMM question1 = new QuestionMM("What is JAVA?");
//
//			List<AnswersMM> answers = new ArrayList<AnswersMM>();
//
//			AnswersMM answer1 = new AnswersMM("JAVA is prog lang", "Dimitar");
//			AnswersMM answer2 = new AnswersMM("JAVA is proggraming lang", "Tom");
//
//			answers.add(answer1);
//			answers.add(answer2);
//
//			question1.setAnswers(answers);
//			
//			
//			QuestionMM question2 = new QuestionMM("What is servlet?");
//			
//			List<AnswersMM> answers2 = new ArrayList<AnswersMM>();
//
//			AnswersMM answer3 = new AnswersMM("Servlet is interface", "Dimitar");
//			AnswersMM answer4 = new AnswersMM("Servlet is API", "Tom");
//
//			answers2.add(answer3);
//			answers2.add(answer4);
//
//			question2.setAnswers(answers2);
//
//			// many-to-many relation is using session.persist //
//			session.persist(question1);
//			session.persist(question2);
//
//			tx.commit();
//			session.close();
// -----------------------------------------------------------------------------------------------
//			// OneToONe //
//			
//
//			Configuration cfg = new Configuration();
//			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Student.class);
//			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Address.class);
//			cfg.configure();
//			factory = cfg.configure().buildSessionFactory();
//			Session session = factory.openSession();
//			tx = session.beginTransaction();
//
//			Student student = new Student("Stole");
//			
//			Address address = new Address("Vasil Gjorgjov", "Skopje", "MK");
//			
//			student.setAddress(address);
//			address.setStudent(student);
//			
//			session.persist(student);
//			
//			tx.commit();
//			session.close();
			
		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		} 
			
		}

	}

