package dao;

import java.util.List;

import model.User;

public interface UserDao {

	User getUser(String email, String password);

	boolean checkIfUserExists(String email);

	void addUser(User user);

	void changePassword(String email, String newPassword);
	
	List<User> getAllUsers();
}
