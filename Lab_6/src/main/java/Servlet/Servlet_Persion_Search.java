package Servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Users;
import Utils.JpaUtils;

@WebServlet("/Servlet_Persion_Search")
public class Servlet_Persion_Search extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/Persion_Search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("Persion_Search")) {
			persionSearch(request, response);
		}
		request.getRequestDispatcher("views/Persion_Search.jsp").forward(request, response);
	}

	protected void persionSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = null;
		
		try {
			em = JpaUtils.getEntityManager();
			
			String id = request.getParameter("id");
			String jpql = "SELECT f.user FROM Favorite f WHERE f.video.id = :id";
			
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("id", id);
			List<Users> list = query.getResultList();
			
			request.setAttribute("users", list);
			request.setAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

}
