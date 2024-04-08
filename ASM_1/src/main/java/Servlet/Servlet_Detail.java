package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Products_DAO;
import Entity.Products;

@WebServlet("/Servlet_Detail")
public class Servlet_Detail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		findID(request, response);
		total(request, response);
		request.getRequestDispatcher("views/Detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		findID(request, response);
		total(request, response);
		request.getRequestDispatcher("views/Detail.jsp").forward(request, response);
	}

	protected void findID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productIdStr = request.getParameter("productId");
		if (productIdStr != null && !productIdStr.isEmpty()) {
			try {
				int productId = Integer.parseInt(productIdStr);
				Products_DAO dao = new Products_DAO();
				Products selectedItems = dao.findById(productId);
				request.setAttribute("selectedItems", selectedItems);
				System.out.println("Product found by category ID: " + productId + ": " + selectedItems);
			} catch (NumberFormatException e) {
				// Xử lý ngoại lệ khi không thể chuyển đổi thành số nguyên
				e.printStackTrace();
				// Hoặc bạn có thể xử lý thông báo lỗi cho người dùng
			}
		}

	}

	protected void total(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		// Lấy số lượng hiện tại từ session hoặc request attribute
		HttpSession session = request.getSession();
		Integer countProduct = (Integer) session.getAttribute("countProduct");
		if (countProduct == null) {
			countProduct = 1; // Giá trị mặc định là 1 nếu chưa được thiết lập
		}

		// Thực hiện các thao tác tăng giảm số lượng sản phẩm
		if ("Tru".equals(action)) {
			countProduct = Math.max(1, countProduct - 1); // Giảm số lượng đi 1, nhưng không nhỏ hơn 1
		} else if ("Cong".equals(action)) {
			countProduct++; // Tăng số lượng lên 1
		}

		// Lưu số lượng mới vào session hoặc request attribute
		session.setAttribute("countProduct", countProduct);

		// Tính tổng tiền
		Products selectedItems = (Products) request.getAttribute("selectedItems");
		if (selectedItems != null) {
			double totalPrice = 0;
			double price = selectedItems.getPrice();
			double sale = selectedItems.getSale();
			if (sale > 0) {
				double discountedPrice = price - (price * sale / 100);
				totalPrice = discountedPrice * countProduct;
			} else {
				totalPrice = price * countProduct;
			}
			request.setAttribute("totalPrice", totalPrice);
		}
	}

}
