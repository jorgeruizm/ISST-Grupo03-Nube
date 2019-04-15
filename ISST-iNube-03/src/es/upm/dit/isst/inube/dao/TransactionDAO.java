package es.upm.dit.isst.inube.dao;

import java.util.List;

import es.upm.dit.isst.inube.model.Transaction;

public interface TransactionDAO {
	
	public void create(Transaction trasaction);
	public Transaction read(int invoice);
	public void update(Transaction transaction);
	public void delete(Transaction transaction);
	public List<Transaction> readAll();
	
}
