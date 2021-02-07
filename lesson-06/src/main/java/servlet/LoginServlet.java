package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userEmail = request.getParameter("login");
		String password = request.getParameter("password");

		User user = userService.getUserByEmail(userEmail);

		if (user != null && user.getPassword().equals(password)) {
			request.setAttribute("userEmail", userEmail);
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

}
