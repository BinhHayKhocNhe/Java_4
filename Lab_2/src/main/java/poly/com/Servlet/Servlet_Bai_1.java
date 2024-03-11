package poly.com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/bai1", "/chuViTamGiac", "/dienTichTamGiac" })
public class Servlet_Bai_1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/Bai_1.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double a = Double.parseDouble(req.getParameter("canhA"));
		double b = Double.parseDouble(req.getParameter("canhB"));
		double c = Double.parseDouble(req.getParameter("canhC"));

		String uri = req.getRequestURI();
		if (!kiemTra(a, b, c)) {
			req.setAttribute("message", "Không thỏa mãn các cạnh của một tam giác!");
		} else {
			if (uri.contains("dienTichTamGiac")) {
				// Tính nửa chu vi
				double p = chuVi(a, b, c) / 2;
				// Tính diện tích sử dụng công thức Heron
				double dienTich = Math.sqrt(p * (p - a) * (p - b) * (p - c));
				dienTich = Math.round(dienTich * 10.0) / 10.0;
				req.setAttribute("dientich", dienTich);
			} else if (uri.contains("chuViTamGiac")) {
				req.setAttribute("chuvi", chuVi(a, b, c));
			}
		}
		req.setAttribute("canha", a);
		req.setAttribute("canhb", b);
		req.setAttribute("canhc", c);
		req.getRequestDispatcher("/views/Bai_1.jsp").forward(req, resp);
	}

	private boolean kiemTra(double a, double b, double c) {
		if ((a + b < c) || (a + c < b) || (b + c < a)) {
			return false;
		}
		return true;
	}

	private double chuVi(double a, double b, double c) {
		return a + b + c;
	}
}
