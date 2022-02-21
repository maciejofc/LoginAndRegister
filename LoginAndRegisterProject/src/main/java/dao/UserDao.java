package dao;

import model.User;

public interface UserDao {

	
	User getUser(String email,String password);
	
	void addUser(User user);
}
