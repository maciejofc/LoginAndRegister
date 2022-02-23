package controller;

import java.io.IOException;
import java.time.LocalDate;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import model.User;

public class Register extends HttpServlet {
	UserDaoImpl userDaoImpl = new UserDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fullName = req.getParameter("userfullname");
		String dateOfBirthString = req.getParameter("userbirthday");
		LocalDate properDateOfBirth = LocalDate.parse(dateOfBirthString);
		String email = req.getParameter("userlogin");
		String password = req.getParameter("userpassword");
		User user = new User(fullName, properDateOfBirth, email, password);
		userDaoImpl.addUser(user);
		resp.sendRedirect("login.jsp");
	}

}
