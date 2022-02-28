package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDaoImpl;

import model.User;

public class Login extends HttpServlet {
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	private static final String INVALID_CREDENTIALS_STATEMENT = "Invalid email or password";

	String  roleToString(User user) {
		return user.getRole().name();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = null;
		String email = request.getParameter("userlogin");
		String password = request.getParameter("userpassword");
		user = userDaoImpl.getUser(email, password);
		List<User> users = userDaoImpl.getAllUsers();

		if (roleToString(user).equals("MEMBER")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("welcome.jsp");
		} else if (roleToString(user).equals("ADMIN")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("users", users);
			response.sendRedirect("welcome.jsp");
		} else {
			request.setAttribute("loginFailure", INVALID_CREDENTIALS_STATEMENT);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}

	}
}
