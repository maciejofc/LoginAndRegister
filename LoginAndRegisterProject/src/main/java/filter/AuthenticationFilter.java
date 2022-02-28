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

public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String path = httpServletRequest.getRequestURI();

		// Disabling filter from certain jsp pages and servlets like login, login.jsp
		// and register, register.jsp
		boolean isPageNotNeededToBeAuth = (path.contains("login") || path.contains("register"))
				|| path.contains("error");
		if (isPageNotNeededToBeAuth) {
			chain.doFilter(request, response);

		} else {
			HttpSession session = httpServletRequest.getSession();
			// prevent from back button when user want to come back to page that
			// need to be auth
			httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			if (session.getAttribute("user") == null) {

				httpServletResponse.sendRedirect("login.jsp");
			} else {

				chain.doFilter(request, response);
			}
		}

	}

}
