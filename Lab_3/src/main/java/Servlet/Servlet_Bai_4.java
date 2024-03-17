package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.Cookies;

@WebServlet("/Servlet_Bai_4")
public class Servlet_Bai_4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = Cookies.get("username", request);
		String password = Cookies.get("password", request);

		request.setAttribute("username", username);
		request.setAttribute("password", password);

		request.getRequestDispatcher("/views/Bai_4_Cookie.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		String message = "";

		if (!(username.equals("abc") && password.equals("123"))) {
			message = "Tên tài khoản hoặc mật khẩu không chính xác !";
		} else {
			message = "Đăng nhập thành công !";
			int hours = remember == null ? 0 : 3;
			Cookies.add("username", username, response, hours);
			Cookies.add("password", password, response, hours);
		}

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/views/Bai_4_Cookie.jsp").forward(request, response);

	}

}
