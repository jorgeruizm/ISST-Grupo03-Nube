package es.upm.dit.isst.inube.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.inube.model.TPV;

public class TPVDAOImplementation implements TPVDAO{

	private static TPVDAOImplementation instance;
	private TPVDAOImplementation() {};
	public static TPVDAOImplementation getInstance() {
		if(null== instance) {
			instance = new TPVDAOImplementation();
		}
		return instance;
	}
	@Override
	public void create(TPV tpv) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(tpv);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}
	@Override
	public TPV read(int id) {
		TPV tpv = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			tpv = session.get(TPV.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tpv;
	}
	@Override
	public void update(TPV tpv) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(tpv);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}
	@Override
	public void delete(TPV tpv) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(tpv);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<TPV> readAll() {
		List<TPV> tpvs = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			tpvs.addAll(session.createQuery("from TPV").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tpvs;
	}
	
}
