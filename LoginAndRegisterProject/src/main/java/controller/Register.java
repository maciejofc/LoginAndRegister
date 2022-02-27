package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import model.User;

public class Register extends HttpServlet {
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	private static final String EMAIL_EXISTS_STATEMENT = "This email is already"
			+ " associated with our system, please try again";
	private static final String SUCCESFUL_REGISTER_STATEMENT = "You have sucesfully" + " registered, please log in ";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullName = req.getParameter("userfullname");
		String dateOfBirthString = req.getParameter("userbirthday");
		LocalDate properDateOfBirth = LocalDate.parse(dateOfBirthString);
		String email = req.getParameter("userlogin");
		String password = req.getParameter("userpassword");
		if (userDaoImpl.checkIfUserExists(email)) {
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			req.setAttribute("errorEmail", EMAIL_EXISTS_STATEMENT);
			rd.include(req, resp);
		} else {
			User user = new User(fullName, properDateOfBirth, email, password);
			userDaoImpl.addUser(user);
			HttpSession session = req.getSession();
			session.setAttribute("registerSuccess", SUCCESFUL_REGISTER_STATEMENT);
			session.setMaxInactiveInterval(60);
			resp.sendRedirect("login.jsp");
		}

	}

}
