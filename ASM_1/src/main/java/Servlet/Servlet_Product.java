package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Categories_DAO;
import DAO.Products_DAO;
import Entity.Categories;
import Entity.Products;

@WebServlet("/Servlet_Product")
public class Servlet_Product extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		findPage(request, response);
		CategoryName(request, response);
		request.getRequestDispatcher("views/Product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void findPage(HttpServletRequest request, HttpServletResponse response) {
		Products_DAO dao = new Products_DAO();

		String categoryId = request.getParameter("categoryId");
		// phân trang theo danh mục
		request.setAttribute("id", categoryId);
		// Kiểm tra xem tham số "page" có tồn tại không
		String pageParam = request.getParameter("page");
		int currentPage = 0;
		if (pageParam != null && !pageParam.isEmpty()) {
			currentPage = Integer.parseInt(pageParam);
		}
		int pageSize = 6;

		List<Products> list = dao.findPage(currentPage, pageSize, categoryId);
		request.setAttribute("product", list);

		for (Products product : list) {
			System.out.println("Product ID: " + product.getProductID());
			System.out.println("Product Name: " + product.getProductName());
		}

		int totalProducts = (int) dao.countProductID(categoryId);
		System.out.println(totalProducts);
		int totalPages = (totalProducts / pageSize) - 1;

		List<Integer> pageNumbers = new ArrayList<>();
		for (int i = 1; i <= totalPages; i++) {
			pageNumbers.add(i);
		}

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("pageNumbers", pageNumbers);
	}

	protected void CategoryName(HttpServletRequest request, HttpServletResponse response) {
		Categories_DAO dao = new Categories_DAO();
		String categoryId = request.getParameter("categoryId");
		String categoryName = dao.CategoryName(categoryId);
		request.setAttribute("categoryName", categoryName);
	}
}
