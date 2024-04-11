package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Users_DAO;
import Entity.Users;

@WebServlet({ "/Servlet_SignUp", "/SignUp" })
public class Servlet_SignUp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("SignUp")) {
			signUp(request, response);
		}
	}

	protected void signUp(HttpServletRequest request, HttpServletResponse response)
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
			String agreed = request.getParameter("agreement");

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
				request.setAttribute("errorMessage",
						"Mật khẩu không hợp lệ. Mật khẩu phải chứa ít nhất 8 ký tự và có ít nhất một ký tự in hoa.");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
				return;
			}

			// Kiểm tra email
			if (!isValidEmail(email)) {
				request.setAttribute("errorMessage", "Email không hợp lệ");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
				return;
			}

			// Kiểm tra số điện thoại
			if (!isValidPhoneNumber(phone)) {
				request.setAttribute("errorMessage",
						"Số điện thoại không hợp lệ. Vui lòng nhập đúng 9 chữ số và loại bỏ số 0 ở đầu!");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
				return;
			}

			if (!isValidAge(formattedBirthday)) {
				request.setAttribute("errorMessage", "Phải đủ 18 tuổi!");
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
				return;
			}
			if (!isValidSignUpInformation(request, username, email, phone)) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
				return;
			}
			if (agreed != null && agreed.equals("on")) {
				Users_DAO dao = new Users_DAO();
				dao.insert(user);
				System.out.println("Thành công");
				request.setAttribute("SignUpSuccess", "Đăng kí tài khoản thành công!");
				request.setAttribute("formattedBirthday", formattedBirthday);
				request.getRequestDispatcher("views/SignIn.jsp").forward(request, response);
			} else {
				request.setAttribute("user", user);
				request.setAttribute("errorMessage", "Vui lòng đồng ý với điều khoản !");
				request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Thất bại");
			request.setAttribute("user", user);
			request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
		}

	}

	protected boolean isValidSignUpInformation(HttpServletRequest request, String username, String email,
			String phone) {
		try {
			Users_DAO dao = new Users_DAO();
			Users user = dao.findById(username);
			if (user != null && user.getUsername().equals(username)) {
				request.setAttribute("errorMessage", "Tài khoản đã được sử dụng !");
				return false;
			} else if (user != null && user.getEmail().equals(email)) {
				request.setAttribute("errorMessage", "Email đã được sử dụng !");
				return false;
			} else if (user != null && user.getPhone().equals(phone)) {
				request.setAttribute("errorMessage", "Số điện thoại đã được sử dụng !");
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
}
