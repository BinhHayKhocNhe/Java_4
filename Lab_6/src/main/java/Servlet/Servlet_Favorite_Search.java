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

@WebServlet("/Servlet_Favorite_Search")
public class Servlet_Favorite_Search extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		favoriteSearch(request, response);
		request.getRequestDispatcher("views/Favorite_Search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/Favorite_Search.jsp").forward(request, response);
	}

	protected void favoriteSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = null;

		try {
			em = JpaUtils.getEntityManager();
			String favorite = request.getParameter("favorite");
			System.out.println(favorite);
			if (favorite == null || favorite.isEmpty()) {
				favorite = "false";
				request.setAttribute("favorite", favorite);
				return;
			}
			String jpql;
			if (favorite.equals("true")) {
				jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
			} else {
				jpql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
			}

			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			List<Video> list = query.getResultList();

			request.setAttribute("Video", list);
			request.setAttribute("favorite", favorite);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

}
