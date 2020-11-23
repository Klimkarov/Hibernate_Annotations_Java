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
public class OneToOne {

	static SessionFactory factory;

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Student.class);
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Address.class);
			cfg.configure();
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			// One to One //

			Student student = new Student("Stole");
			
			Address address = new Address("Vasil Gjorgjov", "Skopje", "MK");
			
			student.setAddress(address);
			address.setStudent(student);
			
			session.persist(student);
			
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		}

	}

}
