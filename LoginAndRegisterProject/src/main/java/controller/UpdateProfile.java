package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDaoImpl;
import model.User;

public class UpdateProfile extends HttpServlet {
	Logger logger =LogManager.getLogger("UpdateProfile");
	private static final String SUCCESFUL_CHANGE_PASSWORD_STATEMENT= "Successfuly changed password"; 
	UserDaoImpl userDaoImpl = new UserDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("newpassword");
		
		User user = (User) req.getSession().getAttribute("user");
		String email  = user.getEmail();
		logger.info(user);
		userDaoImpl.changePassword(email, newPassword);
		logger.info(user.getEmail());
		User newUpdatedUser = userDaoImpl.getUser(email, newPassword);
		req.setAttribute("changeStatement", SUCCESFUL_CHANGE_PASSWORD_STATEMENT);
		req.getSession().setAttribute("user", newUpdatedUser);
		RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
		rd.forward(req, resp);
	}

}
