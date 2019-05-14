package es.upm.dit.isst.inube.dao;

import java.util.List;

import es.upm.dit.isst.inube.model.TPV;

public interface TPVDAO {
	
	public void create(TPV tpv);
	public TPV read(int id);
	public void update(TPV tpv);
	public void delete(TPV tpv);
	public List<TPV> readAll();
}
