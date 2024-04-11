package Servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.zxing.WriterException;
import java.io.OutputStream;
import DAO.Users_DAO;
import Entity.Users;
import Utils.QR_Code;

@WebServlet({ "/Servlet_Information_Manage", "/create", "/update", "/delete", "/reset", "/edit", "/find", "/QRCode" })
public class Servlet_Information_Manage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("UTF-8");
		Users user = null;
		if (url.contains("edit")) {
			Users_DAO dao = new Users_DAO();
			if (request.getParameter("id") != null) {
				int userId = Integer.parseInt(request.getParameter("id"));
				user = dao.findID(userId);
			}
			request.setAttribute("user", user);
		}

		findPage(request, response);
		request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("UTF-8");
		if (url.contains("reset")) {
			request.setAttribute("user", new Users());
		}
		if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("find")) {
			findUser(request, response);
		} else if (url.contains("QRCode")) {
			try {
				QRCode(request, response);
			} catch (ServletException | WriterException e) {
				e.printStackTrace();
			}
		}
		findPage(request, response);
		request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
	}

	protected void findUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users_DAO dao = new Users_DAO();
		String keyword = request.getParameter("keyword");
		if (keyword == null || keyword.isEmpty()) {
			request.setAttribute("error", "Vui lòng nhập thông tin tìm kiếm!");
			request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
			return;
		}
		List<Users> users = dao.findByKeyword(keyword);
		request.setAttribute("users", users);
		request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
	}

	protected void findPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users_DAO dao = new Users_DAO();

		String pageParam = request.getParameter("page");
		int currentPage = 0;
		if (pageParam != null && !pageParam.isEmpty()) {
			currentPage = Integer.parseInt(pageParam);
		}

		int pageSize = 10;

		List<Users> users = dao.findPage(currentPage, pageSize);
		request.setAttribute("users", users);

		int totalUsers = (int) dao.countAll();
		int totalPages = totalUsers / pageSize;
		List<Integer> pageNumbers = new ArrayList<>();
		for (int i = 1; i <= totalPages; i++) {
			pageNumbers.add(i);
		}

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("pageNumbers", pageNumbers);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("ID_User"));
			String username = request.getParameter("Username");
			String password = request.getParameter("Password");
			String fullname = request.getParameter("Fullname");
			String phone = request.getParameter("Phone");
			String email = request.getParameter("Email");
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Birthday"));
			boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
			boolean roleValue = Boolean.parseBoolean(request.getParameter("Role"));

			String role = roleValue ? "Admin" : "User";
			Users user = new Users();
			user.setID_User(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setFullname(fullname);
			user.setPhone(phone);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setGender(gender);
			user.setRole(role);

			Users_DAO dao = new Users_DAO();
			dao.update(user);
			request.setAttribute("message", "Chỉnh sửa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Chỉnh sửa không thành công!");
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			Users user = new Users();
			BeanUtils.populate(user, request.getParameterMap());
			Users_DAO dao = new Users_DAO();
			dao.delete(user.getID_User());
			request.setAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = new Users();
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			// Lấy thông tin từ request
			String username = request.getParameter("Username");
			String password = request.getParameter("Password");
			String fullname = request.getParameter("Fullname");
			String phone = request.getParameter("Phone");
			String email = request.getParameter("Email");
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Birthday"));
			String formattedBirthday = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
			boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
			String role = "User";

			user.setUsername(username);
			user.setPassword(password);
			user.setFullname(fullname);
			user.setPhone("+84" + phone);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setGender(gender);
			user.setRole(role);

			// Kiểm tra mật khẩu
			if (!isValidPassword(password)) {
				request.setAttribute("error",
						"Mật khẩu không hợp lệ. Mật khẩu phải chứa ít nhất 8 ký tự và có ít nhất một ký tự in hoa.");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
				return;
			}

			// Kiểm tra email
			if (!isValidEmail(email)) {
				request.setAttribute("error", "Email không hợp lệ");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
				return;
			}

			// Kiểm tra số điện thoại
			if (!isValidPhoneNumber(phone)) {
				request.setAttribute("error",
						"Số điện thoại không hợp lệ. Vui lòng nhập đúng 9 chữ số và loại bỏ số 0 ở đầu!");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
				return;
			}

			if (!isValidAge(formattedBirthday)) {
				request.setAttribute("error", "Phải đủ 18 tuổi!");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
				return;
			}
			if (!isValidSignUpInformation(request, username, email, phone)) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
				return;
			}

			Users_DAO dao = new Users_DAO();
			dao.insert(user);
			System.out.println("Thành công");
			request.setAttribute("SignUpSuccess", "Đăng kí tài khoản thành công!");
			request.setAttribute("formattedBirthday", formattedBirthday);
			request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Thất bại");
			request.setAttribute("user", user);
			request.getRequestDispatcher("views/Information_Manage.jsp").forward(request, response);
		}

	}

	protected boolean isValidSignUpInformation(HttpServletRequest request, String username, String email,
			String phone) {
		try {
			Users_DAO dao = new Users_DAO();
			Users user = dao.findById(username);
			if (user != null && user.getUsername().equals(username)) {
				request.setAttribute("error", "Tài khoản đã được sử dụng !");
				return false;
			} else if (user != null && user.getEmail().equals(email)) {
				request.setAttribute("error", "Email đã được sử dụng !");
				return false;
			} else if (user != null && user.getPhone().equals(phone)) {
				request.setAttribute("error", "Số điện thoại đã được sử dụng !");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private boolean isValidEmail(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(regex);
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		phoneNumber = phoneNumber.replaceAll("\\s+", "").replaceAll("-", "");
		return phoneNumber.matches("\\d{9}");
	}

	private boolean isValidPassword(String password) {
		return password.length() >= 8 && !password.equals(password.toLowerCase())
				&& !password.equals(password.toUpperCase());
	}

	private boolean isValidAge(String birthdayString) throws ParseException {
		if (birthdayString != null && !birthdayString.isEmpty()) {
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayString);
			// Lấy ngày hiện tại
			Date currentDate = new Date();
			// Tính toán tuổi
			long ageInMillis = currentDate.getTime() - birthday.getTime();
			long ageInYears = ageInMillis / (1000L * 60 * 60 * 24 * 365);
			// Kiểm tra tuổi
			return ageInYears >= 18;
		}
		return false;
	}

	private void QRCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, WriterException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int size = 300;
		String fileType = "png";
		int id = Integer.parseInt(request.getParameter("ID_User"));
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String fullname = request.getParameter("Fullname");

		String qrText = "ID: " + id + "\nUsername: " + username + "\nPassword: " + password + "\nFullname: " + fullname;

		String fileName = "qr_code.png"; 
		String filePath = getServletContext().getRealPath("img/") + fileName;
		File qrFile = new File(filePath);
		QR_Code.createQRImage(qrFile, qrText, size, fileType);

		// Trả về URL của file
		String qrUrl = request.getContextPath() + "img/" + fileName;
		response.getWriter().write(qrUrl);
	}

}
