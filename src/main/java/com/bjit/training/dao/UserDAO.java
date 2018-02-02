package com.bjit.training.dao;

import java.util.List;

import com.bjit.training.model.User;

public interface UserDAO {
	public void save(User user);
//	public void deleteUser(int userId);
	public User updateUser (int userId);
	public List<User> userDetails();
	public User getSpecificUser(int id);
	public void deleteSpecificUser(int id);

}
