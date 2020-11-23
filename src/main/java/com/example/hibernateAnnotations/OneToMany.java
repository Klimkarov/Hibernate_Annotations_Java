package com.example.hibernateAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class OneToMany {

	static SessionFactory factory;

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Question.class);
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Answers.class);
			cfg.configure();
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			// One to Many //

			Question question = new Question("What is JAVA?");

			List<Answers> answers = new ArrayList<Answers>();

			Answers answer1 = new Answers("JAVA is prog lang", "Dimitar");
			Answers answer2 = new Answers("JAVA is proggraming lang", "Tom");

			answers.add(answer1);
			answers.add(answer2);

			question.setAnswers(answers);

			// one-to-many relation is using session.persist //
			session.persist(question);

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		}

	}

}
