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
public class ManyToOne {

	static SessionFactory factory;

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Employee.class);
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Project.class);
			cfg.addAnnotatedClass(com.example.hibernateAnnotations.Department.class);
			cfg.configure();
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();

			// Many to One //

			Project project = new Project("ProjectX", "Explination about the project");
			session.save(project);
			Department dept = new Department("Dept1", 11, project);
			session.save(dept);
			Date date = new Date(System.currentTimeMillis());
			Employee emp = new Employee("Dimitar", "Josifov", 123455, date, dept);
			session.save(emp);

			// JOIN e.department d WHERE d.id=:deptId
			String hql = "SELECT e FROM Employee e WHERE e.id=:empid";
			Query query = session.createQuery(hql);
			List<Employee> res = query.setParameter("empid", 3).list();
			System.out.println(res.get(0).getFirstName());

			Department d = res.get(0).getDepartment();
			System.out.println(d.getDeptName());

			Project p = d.getProject();
			System.out.println(p.getProjectName());

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println(e);
			tx.rollback();
		}

	}

}
