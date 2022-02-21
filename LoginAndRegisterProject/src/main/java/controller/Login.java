package controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import model.User;

public class Login extends HttpServlet {
	UserDaoImpl userDaoImpl = new UserDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = null;
		String email = request.getParameter("userlogin");
		String password = request.getParameter("userpassword");
		user = userDaoImpl.getUser(email, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userlogin", email);
			session.setAttribute("userpassword", password);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}
}