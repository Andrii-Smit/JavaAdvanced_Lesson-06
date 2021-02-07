package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");

		if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !userEmail.isEmpty()
				&& !password.isEmpty()) {
			userService.create(new User(firstName, lastName, address, userEmail, password));
		}

		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

}
