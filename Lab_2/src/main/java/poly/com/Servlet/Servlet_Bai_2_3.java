package poly.com.Servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bai2")

public class Servlet_Bai_2_3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		req.getRequestDispatcher("/views/Bai_2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String marriage = req.getParameter("marriage");
		String country = req.getParameter("country");
		String note = req.getParameter("note");
		String favorites[] = req.getParameterValues("favorite");
		String marrialStatus = "";

		marrialStatus = (marriage == null) ? "Độc thân !" : marriage;

		StringBuilder sb = new StringBuilder();
		for (String item : favorites) {
			sb.append(item).append(", ");
		}

		String favoriteConvert = "";
		if (sb.toString() != null) {
			favoriteConvert = sb.toString().substring(0, sb.toString().lastIndexOf(",")) + ".";
		}

		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.setAttribute("marriage", marrialStatus);
		req.setAttribute("gender", gender);
		req.setAttribute("country", country);
		req.setAttribute("note", note);
		req.setAttribute("favorites", favoriteConvert);
		req.getRequestDispatcher("/views/Result.jsp").forward(req, resp);
	}
}
