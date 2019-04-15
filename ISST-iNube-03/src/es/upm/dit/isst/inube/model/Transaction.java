package es.upm.dit.isst.inube.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	private int invoice;
	private double amount;
	private String date;
	private int client;
	private String time;

	@ManyToOne
	private TPV tpv;
	
	public Transaction() {}
	
	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TPV getTpv() {
		return tpv;
	}

	public void setTpv(TPV tpv) {
		this.tpv = tpv;
	}
	
}
