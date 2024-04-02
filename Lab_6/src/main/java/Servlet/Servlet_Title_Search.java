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

import Entity.Video;
import Utils.JpaUtils;

@WebServlet("/Servlet_Title_Search")
public class Servlet_Title_Search extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/Title_Search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("Servlet_Title_Search")) {
			titleSearch(request, response);
		}
		request.getRequestDispatcher("views/Title_Search.jsp").forward(request, response);
	}

	protected void titleSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			String title = request.getParameter("title");
			String jpqlQuery = "SELECT DISTINCT v FROM Video v WHERE v.title LIKE :keyword";
			TypedQuery<Video> query = em.createQuery(jpqlQuery, Video.class);
			query.setParameter("keyword", "%" + title + "%");
			List<Video> list = query.getResultList();
			request.setAttribute("videos", list);
			request.setAttribute("keyword", title);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}
}
