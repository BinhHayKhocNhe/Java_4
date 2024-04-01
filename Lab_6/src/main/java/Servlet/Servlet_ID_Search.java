package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Entity.Favorite;
import Entity.Users;
import Utils.JpaUtils;

@WebServlet("/Servlet_ID_Search")
public class Servlet_ID_Search extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/ID_Search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("Servlet_ID_Search")) {
			idSearch(request, response);
		}
		request.getRequestDispatcher("views/ID_Search.jsp").forward(request, response);
	}

	protected void idSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || id.isEmpty()) {
			request.setAttribute("error_id", "Invalid username!");
			return;
		}

		try {
			UserDAO dao = new UserDAO();
			Users user = dao.findById(id);
//			EntityManager em1 = JpaUtils.getEntityManager();
//			Users user = em1.find(Users.class, id);

			if (user != null) {
				List<Favorite> favorites = user.getFavorites();
				request.setAttribute("user", user);
				request.setAttribute("favorites", favorites);
				return;
			}
			request.setAttribute("error_id", "User not found!");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_id", "Username invalid!");
		}
	}
}
