package es.upm.dit.isst.inube.rest;

import java.util.List;

import es.upm.dit.isst.inube.dao.TransactionDAO;
import es.upm.dit.isst.inube.dao.TransactionDAOImplementation;
import es.upm.dit.isst.inube.model.Transaction;

public class Database {
	
	int edad1825;
	int edad2635;
	int edad3650;
	int edad5170;
	static List<Transaction> transacciones;
	
	public static void loadAll() {
		
		TransactionDAO tdao = TransactionDAOImplementation.getInstance();
		List<Transaction> transactions = tdao.readAll();
		System.out.println("Factura: " + transactions.get(0).getInvoice() + "\n" +
						   "Edad: " + transactions.get(0).getAge() + "\n" +
						   "Importe: " + transactions.get(0).getAmount() + "\n" + 
						   "Cliente: " + transactions.get(0).getClient() + "\n" + 
						   "Fecha: " + transactions.get(0).getMonth());
		transacciones = tdao.readAll();
		
	}
	
	public void rangosEdad() {
		
	}
	
	

}
