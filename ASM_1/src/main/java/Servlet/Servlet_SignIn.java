package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Users_DAO;
import Entity.Users;

@WebServlet({ "/Servlet_SignIn", "/sign-in" })
public class Servlet_SignIn extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// User null mỗi khi logout
//		request.getSession().setAttribute("user", null);
		request.getRequestDispatcher("views/SignIn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();

		if (uri.contains("sign-in")) {
			signIn(request, response);
		}
	}

	protected void signIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean loggedIn = false;
		try {
			String username = request.getParameter("Username");
			String password = request.getParameter("Password");

			Users_DAO dao = new Users_DAO();
			Users user = dao.findById(username);

			if (user != null && password.equalsIgnoreCase(user.getPassword())) {
				loggedIn = true;
			} else {
				request.setAttribute("message", "Tên tài khoản hoặc mật khẩu không chính xác");
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.getRequestDispatcher("views/SignIn.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			request.setAttribute("message", "Tên tài khoản hoặc mật khẩu không chính xác");
			request.getRequestDispatcher("views/SignIn.jsp").forward(request, response);
			return;
		}

		request.setAttribute("loggedIn", loggedIn);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
