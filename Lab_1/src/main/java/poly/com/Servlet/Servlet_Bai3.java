package poly.com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bai3")
public class Servlet_Bai3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/Bai_3.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("txtName");
		String address = req.getParameter("txtAddress");
		String gender = req.getParameter("gioiTinh");

		req.setAttribute("truyenFullName", fullName);
		req.setAttribute("truyenAddress", address);
		req.setAttribute("truyenGender", gender);
		req.getRequestDispatcher("/views/Bai_3.jsp").forward(req, resp);
	}
}
