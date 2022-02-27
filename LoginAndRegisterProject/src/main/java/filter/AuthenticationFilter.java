package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;







public class AuthenticationFilter implements Filter {
Logger logger =LogManager.getLogger("AuthenticationFilter");
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String path = httpServletRequest.getRequestURI();
		logger.info(path);
		// Disabling filter from certain jsp pages and servlets like login, login.jsp and register, register.jsp
		boolean isPageNotNeededToBeAuth = (path.contains("login") || path.contains("register")) || path.contains("error");
		if (isPageNotNeededToBeAuth) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = httpServletRequest.getSession();
			// prevent from back button when user want to come back to page that
			// need to be auth
			httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			if (session.getAttribute("user") == null) {
				logger.info(path);
				httpServletResponse.sendRedirect("register.jsp");
			} else {
				logger.info(path);
				chain.doFilter(request, response);
			}
		}

	}

}
