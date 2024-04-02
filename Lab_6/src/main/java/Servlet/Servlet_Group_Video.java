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

import Entity.Report;
import Utils.JpaUtils;

@WebServlet("/Servlet_Group_Video")
public class Servlet_Group_Video extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		groupVideo(request, response);
		request.getRequestDispatcher("views/Group_Video.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void groupVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			String jpql = "SELECT NEW Report(o.video.title, COUNT(o), MAX(o.likeDate), MIN(o.likeDate))"
					+ " FROM Favorite o GROUP BY o.video.title";
			TypedQuery<Report> query = em.createQuery(jpql, Report.class);
			List<Report> list = query.getResultList();
			request.setAttribute("reports", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

}
