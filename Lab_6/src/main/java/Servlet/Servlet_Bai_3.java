package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Users;
import Entity.Video;
import Utils.JpaUtils;

@WebServlet({ "/bai3-title", "/bai3-id", "/bai3-range", "/bai3-months" })
public class Servlet_Bai_3 extends HttpServlet {

	private EntityManager em = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String url = request.getRequestURL().toString();
		if (url.contains("bai3-title")) {
			forward = "bai3-title.jsp";
		} else if (url.contains("bai3-id")) {
			forward = "bai3-id.jsp";
		} else if (url.contains("bai3-range")) {
			forward = "bai3-range.jsp";
		} else if (url.contains("bai3-months")) {
			forward = "bai3-months.jsp";
		}
		request.getRequestDispatcher("/views/" + forward).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String url = request.getRequestURL().toString();

		if (url.contains("bai3-title")) {
			titleSearch(request, response);
			forward = "bai3-title.jsp";
		} else if (url.contains("bai3-id")) {
			idSearch(request, response);
			forward = "bai3-id.jsp";
		} else if (url.contains("bai3-range")) {
			rangeSearch(request, response);
			forward = "bai3-range.jsp";
		} else if (url.contains("bai3-months")) {
			monthSearch(request, response);
			forward = "bai3-months.jsp";
		}
		request.getRequestDispatcher("/views/" + forward).forward(request, response);
	}

	protected void titleSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			em = JpaUtils.getEntityManager();
			String title = request.getParameter("title");
			TypedQuery<Video> query = em.createNamedQuery("Video.findByKeyword", Video.class);
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

	protected void idSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			em = JpaUtils.getEntityManager();
			String id = request.getParameter("id");
			if (id == null || id.isEmpty()) {
				request.setAttribute("error_id", "Username invalid!");
			} else {
				Users user = em.find(Users.class, id);
				if (user == null) {
					request.setAttribute("error_id", "Username invalid!");
				} else {
					TypedQuery<Video> query = em.createNamedQuery("Video.findByUser", Video.class);
					query.setParameter("id", id);
					List<Video> videos = query.getResultList();
					request.setAttribute("user", user);
					request.setAttribute("favorite", videos);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_id", "Username invalid!");
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	protected void rangeSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			em = JpaUtils.getEntityManager();
			String dateFrom = request.getParameter("dateFrom");
			String dateTo = request.getParameter("dateTo");

			if (!dateFrom.isEmpty() && !dateTo.isEmpty()) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date fromDate = format.parse(dateFrom);
				Date toDate = format.parse(dateTo);

				TypedQuery<Video> query = em.createNamedQuery("Video.findInRange", Video.class);
				query.setParameter("min", fromDate);
				query.setParameter("max", toDate);

				List<Video> videos = query.getResultList();

				request.setAttribute("videos", videos);
				request.setAttribute("dateFrom", dateFrom);
				request.setAttribute("dateTo", dateTo);
			} else {
				request.setAttribute("error_date", "Date is null!");
				request.setAttribute("dateFrom", dateFrom);
				request.setAttribute("dateTo", dateTo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_date", "Failed to process date!");
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

	protected void monthSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			em = JpaUtils.getEntityManager();
			String[] months = request.getParameterValues("month");

			if (months != null) {
				List<Integer> selectedMonths = new ArrayList<>();
				for (String month : months) {
					selectedMonths.add(Integer.parseInt(month));
				}

				List<Boolean> resultList = new ArrayList<>();
				for (int i = 1; i <= 12; i++) {
					resultList.add(selectedMonths.contains(i));
				}

				TypedQuery<Video> query = em.createNamedQuery("Video.findInMonths", Video.class);
				query.setParameter("months", selectedMonths);
				List<Video> videos = query.getResultList();

				request.setAttribute("videos", videos);
				request.setAttribute("result", resultList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_date", "Fail!");
		} finally {
			JpaUtils.closeEntityManager(em);
			JpaUtils.shutDown();
		}
	}

}
