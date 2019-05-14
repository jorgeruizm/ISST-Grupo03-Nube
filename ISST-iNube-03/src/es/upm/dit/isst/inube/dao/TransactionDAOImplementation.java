package es.upm.dit.isst.inube.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.inube.model.TPV;
import es.upm.dit.isst.inube.model.Transaction;

public class TransactionDAOImplementation implements TransactionDAO {
	
	private static TransactionDAOImplementation instance;
	private TransactionDAOImplementation() {};
	public static TransactionDAOImplementation getInstance() {
		if(null== instance) {
			instance = new TransactionDAOImplementation();
		}
		return instance;
	}

	@Override
	public void create(Transaction transaction) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(transaction);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}

	@Override
	public Transaction read(int invoice) {
		Transaction transaction = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			transaction = session.get(Transaction.class, invoice);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return transaction;
	}

	@Override
	public void update(Transaction transaction) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(transaction);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Transaction transaction) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(transaction);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}	
	}

	@Override
	public List<Transaction> readAll() {
		List<Transaction> transactions = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			transactions.addAll(session.createQuery("from Transaction").list());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return transactions;
	}
	
	@Override
	public List<Transaction> totalAmount(String date) {
		List<Transaction> transactions = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			transactions.addAll( session.createQuery("select e from transaction e where e.date = :date")
					.setParameter("date", date).list());
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
		return transactions;
	}
	
}
