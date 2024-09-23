package com.sit.repositoryIMPL;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sit.entity.User;
import com.sit.repository.Repository;

public class RepositoryIMPL implements Repository {

	@Override
	public void addStudent(User user) {
		Configuration cfg = new Configuration();
		cfg.configure();

		try (SessionFactory factory = cfg.buildSessionFactory(); Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			System.out.println("Data Stored Successfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User authenticateUser(String username, String password) {
		Configuration cfg = new Configuration().configure();

		try (SessionFactory factory = cfg.buildSessionFactory(); Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("email", username));
			criteria.add(Restrictions.eq("pass", password));
			return (User) criteria.uniqueResult();
		}
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		Configuration cfg = new Configuration().configure();

		try (SessionFactory factory = cfg.buildSessionFactory(); Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			criteria.setProjection(Projections.rowCount());
			Long count = (Long) criteria.uniqueResult();
			return count > 0;
		}
	}

}
