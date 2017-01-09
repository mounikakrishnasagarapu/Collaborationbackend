package com.niit.dao;

import java.util.List;

import com.niit.models.User;

public interface UserDAO {
	public List<User> list();
	public User get(int id);
    public boolean saveOrUpdate(User user);
	public User validate(int id,String password);
}
