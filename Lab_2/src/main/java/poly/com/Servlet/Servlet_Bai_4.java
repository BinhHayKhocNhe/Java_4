package poly.com.Servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Patch;

@WebServlet("/bai3")
public class Servlet_Bai_4 extends HttpServlet {
	int count = 0;
	Path path = Paths.get("C://Temp//count.txt");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/Bai_4.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init(ServletConfig config) {
		try {
			count = Integer.parseInt(Files.readAllLines(path).get(0));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void destroy() {
		try {
			Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		count++;
		req.setAttribute("count", count);
		req.getRequestDispatcher("/views/Bai_4.jsp").forward(req, resp);
	}
}
