package es.upm.dit.isst.inube.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.inube.model.Business;

public class BusinessDAOImplementation implements BusinessDAO{
	
	private static BusinessDAOImplementation instance;
	private BusinessDAOImplementation() {};
	public static BusinessDAOImplementation getInstance() {
		if(null== instance) {
			instance = new BusinessDAOImplementation();
		}
		return instance;
	}

	@Override
	public void create(Business business) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(business);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Business read(String merchant) {
		Business business = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			business = session.get(Business.class, merchant);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return business;
	}

	@Override
	public void update(Business business) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(business);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Business business) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(business);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Business> readAll() {
		List<Business> business = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			business.addAll(session.createQuery("from Business").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return business;
	}

}
