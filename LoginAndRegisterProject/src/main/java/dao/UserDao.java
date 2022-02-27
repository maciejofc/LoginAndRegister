package dao;

import model.User;

public interface UserDao {

	User getUser(String email, String password);

	boolean checkIfUserExists(String email);

	void addUser(User user);

	void changePassword(String email, String newPassword);
}
