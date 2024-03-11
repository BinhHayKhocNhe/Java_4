package poly.com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/bai2")
public class Servlet_Bai2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/Bai_2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double length, width;
		length = Double.parseDouble(req.getParameter("chieuDai"));
		width = Double.parseDouble(req.getParameter("chieuRong"));
		double chuVi = (length + width) * 2;
		double dienTich = (length + width);
		req.setAttribute("truyenChuVi", chuVi);
		req.setAttribute("truyenDienTich", dienTich);
		req.getRequestDispatcher("/views/Bai_2.jsp").forward(req, resp);
	}
}
