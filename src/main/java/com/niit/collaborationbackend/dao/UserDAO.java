package com.niit.collaborationbackend.dao;

import java.util.List;

import com.niit.collaborationbackend.model.User;

public interface UserDAO {
	public List<User> list();
	public User get(int id);
    public boolean saveOrUpdate(User user);
	public User validate(int id,String password);
	public User profileof(String username);
	public User oneuser(int uid);
	public List<User> nonfriends(int uid);
	public User authuser(String username, String password);
	public List<User> getuser(int id);
}
