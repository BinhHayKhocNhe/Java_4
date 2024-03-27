package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import Model.User;

@WebServlet({ "/user/index", "/user/create", "/user/update", "/user/delete", "/user/reset", "/user/edit/*",
		"/user/delete/*" })
public class Servlet_Bai_3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("UTF-8");
		User user = null;

		if (url.contains("delete")) {
			UserDAO dao = new UserDAO();
			if (request.getParameter("id") != null) {
				dao.delete(request.getParameter("id"));
				request.setAttribute("message", "Delete success!");
			}
			// xóa rỗng các ô texbox
			user = new User();
			request.setAttribute("user", user);
		} else if (url.contains("edit")) {
			UserDAO dao = new UserDAO();
			if (request.getParameter("id") != null) {
				user = dao.findById(request.getParameter("id"));
			}
			request.setAttribute("user", user);
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/Bai_3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("UTF-8");
		if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/Bai_3.jsp").forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.create(user);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.update(user);
			request.setAttribute("message", "Update success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			if (user.getId() != null)
				dao.delete(user.getId());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDAO userDAO = new UserDAO();
			List<User> list = userDAO.findAll();
			request.setAttribute("users", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
