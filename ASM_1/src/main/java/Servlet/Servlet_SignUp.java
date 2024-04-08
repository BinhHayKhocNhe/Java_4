package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Users_DAO;
import Entity.Users;

@WebServlet({ "/Servlet_SignUp", "/SignUp" })
public class Servlet_SignUp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("SignUp")) {
			signUp(request, response);
		}
	}

	protected void signUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String username = request.getParameter("Username");
			String password = request.getParameter("Password");
			String fullname = request.getParameter("Fullname");
			String phone = request.getParameter("Phone");
			String email = request.getParameter("Email");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = formatter.parse(request.getParameter("Birthday"));

			boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));

			String role = "User";

			boolean isInformationValid = checkInformation(request, response, username, email, phone);
			if (!isInformationValid) {
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
				return;
			}
			Users_DAO dao = new Users_DAO();
			Users user = new Users(username, password, fullname, email, phone, gender, birthday, role);
			dao.insert(user);
			System.out.println("Thành công");
			request.getRequestDispatcher("views/SignIn.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Thất bại");
			request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
		}
	}

	protected boolean checkInformation(HttpServletRequest request, HttpServletResponse response, String username,
			String email, String phone) {
		try {
			Users_DAO dao = new Users_DAO();
			Users user = dao.findById(username);
			if (user != null && user.getUsername().equals(username)) {
				System.out.println("Tài khoản đã được sử dụng !");
				request.setAttribute("errorMessage", "Tài khoản đã được sử dụng !");
				return false;
			} else if (user != null && user.getEmail().equals(email)) {
				System.out.println("Email đã được sử dụng !");
				request.setAttribute("errorMessage", "Email đã được sử dụng !");
				return false;
			} else if (user != null && user.getPhone().equals(phone)) {
				System.out.println("Số điện thoại đã được sử dụng !");
				request.setAttribute("errorMessage", "Số điện thoại đã được sử dụng !");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
