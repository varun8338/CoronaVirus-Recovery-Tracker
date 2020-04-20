package org.dao;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsersDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
			.buildSessionFactory();

	public void createUser(Users user) {
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();

		System.out.println("User created");
	}

	public Users getUsers(String username) {

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Users user = session.get(Users.class, username);
		return user;
	}

}
