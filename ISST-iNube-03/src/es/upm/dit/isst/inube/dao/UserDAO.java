package es.upm.dit.isst.inube.dao;

import java.util.*;

import es.upm.dit.isst.inube.model.User;

public interface UserDAO {
	
	public void create(User user);
	public User read(String email);
	public void update(User user);
	public void delete(User user);
	public List<User> readAll();
	
}

