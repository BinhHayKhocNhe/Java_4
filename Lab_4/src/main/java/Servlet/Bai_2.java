package Servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;

@WebServlet("/Bai_2")
public class Bai_2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> users = Arrays.asList(new User[] { new User("Minh Bình", "123", true),
				new User("Mỹ Thuận", "1234", true), new User("Nhi", "123", false) });

		request.setAttribute("message", "Quản lý người sử dụng!");
		request.setAttribute("form", users.get(0));
		request.setAttribute("items", users);
		request.getRequestDispatcher("/views/table.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
