package es.upm.dit.isst.inube.dao;

import java.util.ArrayList;
import java.util.*;

import org.hibernate.Session;

import es.upm.dit.isst.inube.model.User;

public class UserDAOImplementation implements UserDAO{
	
	private static UserDAOImplementation instance;
	private UserDAOImplementation() {};
	public static UserDAOImplementation getInstance() {
		if(null== instance) {
			instance = new UserDAOImplementation();
		}
		return instance;
	}

	@Override
	public void create(User user) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public User read(String email) {
		User user = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			user = session.get(User.class, email);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public void update(User user) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(User user) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public List<User> readAll() {
		List<User> users = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			users.addAll(session.createQuery("from User").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

}
