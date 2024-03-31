package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Model.User;

@WebServlet({ "/Servlet_Bai_5" })
public class Servlet_Bai_5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();

		// Kiểm tra xem tham số "page" có tồn tại không
		String pageParam = request.getParameter("page");
		int currentPage = 0; // Giá trị mặc định nếu không có tham số "page"
		if (pageParam != null && !pageParam.isEmpty()) {
			currentPage = Integer.parseInt(pageParam);
		}

		int pageSize = 4;

		List<User> users = dao.findPage(currentPage, pageSize);
		request.setAttribute("users", users);

		int totalUsers = (int) dao.countAll();
		int totalPages = totalUsers / pageSize;
		List<Integer> pageNumbers = new ArrayList<>();
		for (int i = 1; i <= totalPages; i++) {
			pageNumbers.add(i);
		}

		// Đặt các giá trị vào request để sử dụng trong JSP
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("pageNumbers", pageNumbers);
		request.getRequestDispatcher("/views/Bai_5.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		int totalUsers = (int) dao.countAll();
		System.out.println(totalUsers);
	}
}
