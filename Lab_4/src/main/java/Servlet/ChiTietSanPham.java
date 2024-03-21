package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Item;

@WebServlet("/ChiTietSanPham")
public class ChiTietSanPham extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("id");
		selectById(name, request);
		request.getRequestDispatcher("/views/chiTiet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void selectById(String name, HttpServletRequest request) throws ServletException, IOException {
		{
			List<Item> items = Arrays.asList(new Item[] { new Item("Sản phẩm 1", "img/product-1.jpeg", 500, 0.1),
					new Item("Sản phẩm 2", "img/product-2.jpeg", 700, 0.15),
					new Item("Sản phẩm 3", "img/product-3.jpeg", 900, 0.25),
					new Item("Sản phẩm 4", "img/product-4.jpeg", 55, 0.3),
					new Item("Sản phẩm 5", "img/product-2.jpeg", 70, 0.5),
					new Item("Sản phẩm 6", "img/product-3.jpeg", 200, 0.2) });
			ArrayList<Item> selectedItems = new ArrayList<>();
			for (Item item : items) {
				if (item.getName().equalsIgnoreCase(name)) {
					selectedItems.add(item);
				}
			}

			request.setAttribute("selectedItems", selectedItems);
		}
	}
}
