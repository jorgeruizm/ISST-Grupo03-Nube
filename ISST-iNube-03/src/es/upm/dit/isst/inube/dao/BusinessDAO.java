package es.upm.dit.isst.inube.dao;

import java.util.List;

import es.upm.dit.isst.inube.model.Business;

public interface BusinessDAO {

	public void create(Business business);
	public Business read(String merchant);
	public void update(Business business);
	public void delete(Business business);
	public List<Business> readAll();
	
}
