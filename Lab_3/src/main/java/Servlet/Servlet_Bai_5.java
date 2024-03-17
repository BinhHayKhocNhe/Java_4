package Servlet;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/Servlet_Bai_5", "/ForgetPassword" })
public class Servlet_Bai_5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("display", "none");
		request.getRequestDispatcher("/views/Bai_5_Mail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String email = "binhdmps32770@fpt.edu.vn";
		final String password = "nwnpvewyswuypsuk";

		String toEmail = request.getParameter("to");

		HttpSession session1 = request.getSession(true);
		int number;
		Object numberObj = session1.getAttribute("verificationNumber");
		if (numberObj == null) {
			// Nếu không có số xác minh trong session, tạo số mới
			number = (int) (Math.random() * 900000) + 100000;
			session1.setAttribute("verificationNumber", number);
		} else {
			// Nếu có số xác minh trong session, sử dụng số đó
			number = (int) numberObj;
		}
		String messageContent = "Mã xác minh là: " + number;

		if (request.getRequestURI().contains("Servlet_Bai_5")) {
			try {
				Properties p = new Properties();
				p.put("mail.smtp.auth", "true");
				p.put("mail.smtp.starttls.enable", "true");
				p.put("mail.smtp.ssl.protocols", "TLSv1.2");
				p.put("mail.smtp.host", "smtp.gmail.com");
				p.put("mail.smtp.port", 587);
				p.put("mail.debug", "true");
				Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(email, password);
					}
				});

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
				message.setSubject("Mã xác minh");
				message.setText(messageContent);

				Transport.send(message);
				request.setAttribute("message", "Send email success!");

				request.setAttribute("display", "block;");
				request.setAttribute("toEmail", toEmail);
			} catch (Exception e) {

				e.printStackTrace();
				request.setAttribute("message", "Send email fail!");
				request.setAttribute("display", "none;");
				request.setAttribute("toEmail", toEmail);

			}
		} else if (request.getRequestURI().contains("ForgetPassword")) {
			try {
				
				int numForget = Integer.parseInt(request.getParameter("forget"));
				String messageForget = forget(number, numForget) ? "Đổi mật khẩu thành công"
						: "Đổi mật khẩu không thành công";
				request.setAttribute("messageForget", messageForget);
				request.getRequestDispatcher("/views/Result.jsp").forward(request, response);
				return;
				
			} catch (Exception e) {
				e.getMessage();
			}
		}

		request.getRequestDispatcher("/views/Bai_5_Mail.jsp").forward(request, response);
	}

	private boolean forget(int number, int userForget) {
		return number == userForget;
	}

}
