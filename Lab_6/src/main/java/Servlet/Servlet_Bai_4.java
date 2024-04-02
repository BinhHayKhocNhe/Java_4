package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Video;
import Utils.JpaUtils;

@WebServlet({ "/bai4-ran", "/bai4-year" })
public class Servlet_Bai_4 extends HttpServlet {
	private EntityManager em = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String url = request.getRequestURL().toString();
		if (url.contains("bai4-ran")) {
			random10(request, response);
			forward = "bai4-ran.jsp";
		} else if (url.contains("bai4-year")) {
			if (request.getParameter("year") == null) {
				yearSelect(request, response);
			} else {
				yearSearch(request, response);
			}
			forward = "bai4-year.jsp";
		}
		request.getRequestDispatcher("/views/" + forward).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void random10(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			em = JpaUtils.getEntityManager();
			Query query = em.createNamedQuery("Report.random10");
			List<Video> video = query.getResultList();
			request.setAttribute("videos", video);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_date", "Fail!");
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	protected void yearSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			em = JpaUtils.getEntityManager();
			Integer year = Integer.parseInt(request.getParameter("year"));
			Integer index = Integer.parseInt(request.getParameter("index"));
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.favoriteByYear");
			query.setParameter("year", year);
			List<Object[]> reports = query.getResultList();
			request.setAttribute("reports", reports);
			request.setAttribute("index", index);
			TypedQuery<Integer> query1 = em.createNamedQuery("Video.selectYear", Integer.class);
			List<Integer> year1 = query1.getResultList();
			List<Object[]> yearyear = new ArrayList<>();
			for (int i = 0; i < year1.size(); i++) {
				Object[] row = new Object[] { year1.get(i), i };
				yearyear.add(row);
			}
			request.setAttribute("years", yearyear);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	protected void yearSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			em = JpaUtils.getEntityManager();
			TypedQuery<Integer> query = em.createNamedQuery("Video.selectYear", Integer.class);
			List<Integer> year = query.getResultList();
			List<Object[]> yearyear = new ArrayList<>();
			for (int i = 0; i < year.size(); i++) {
				Object[] row = new Object[] { year.get(i), i };
				yearyear.add(row);
			}
			request.setAttribute("years", yearyear);
			StoredProcedureQuery query2 = em.createNamedStoredProcedureQuery("Report.favoriteByYear");
			query2.setParameter("year", year.get(0));
			List<Object[]> reports = query2.getResultList();
			request.setAttribute("reports", reports);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}
}
