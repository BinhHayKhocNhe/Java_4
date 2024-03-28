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

@WebServlet({ "/sign-in", "/sign-up", "/sign-out", "/forgot-password", "/change-password", "/edit-profile" })
public class Servlet_Bai_4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/Bai_4.jsp").forward(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

//Thực hiện trước service
//		if (request.getMethod().equals("GET")) {
//	        this.doGet(request, response);
//	        return; // Kết thúc phương thức service() sau khi gọi doGet()
//	    }

		if (uri.contains("sign-in")) {
			this.doSignIn(request, response);
		} else if (uri.contains("sign-up")) {
			this.doSignUp(request, response);
		} else if (uri.contains("edit-profile")) {
			this.doEditProfile(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void doSignIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();

		if (!method.equalsIgnoreCase("POST")) {
			request.getRequestDispatcher("/views/SignIn.jsp").forward(request, response);
			return;
		}

		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		try {
			UserDAO dao = new UserDAO();
			User user = dao.findById(id);
			if (user != null && user.getPassword().equals(pw)) {
				request.setAttribute("message", "Đăng nhập thành công!");
				request.getSession().setAttribute("user", user);
			} else {
				request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
			}
		} catch (Exception e) {
			request.setAttribute("error", "Đã xảy ra lỗi khi đăng nhập!");
		}

		request.getRequestDispatcher("/views/SignIn.jsp").forward(request, response);
	}

	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				User entity = new User();
				BeanUtils.populate(entity, req.getParameterMap());
				UserDAO dao = new UserDAO();
				dao.create(entity);
				req.setAttribute("message", "Đăng ký thành công!");
			} catch (Exception e) {
				req.setAttribute("error", "Lỗi đăng ký!");
			}
		}
		req.getRequestDispatcher("/views/SignUp.jsp").forward(req, resp);
	}

	private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("UTF-8");
		User user = null;

		if (url.contains("edit")) {
			UserDAO dao = new UserDAO();
			if (req.getParameter("id") != null) {
				user = dao.findById(req.getParameter("id"));
			}
			req.setAttribute("user", user);
		}
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				UserDAO dao = new UserDAO();
				dao.update(user);
				req.setAttribute("message", "Cập nhật tài khoản thành công!");
			} catch (Exception e) {
				req.setAttribute("error", "Lỗi cập nhật tài khoản!");
			}
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/Update.jsp").forward(req, resp);
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
