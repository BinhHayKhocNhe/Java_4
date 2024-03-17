package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import java.nio.file.Paths;

import Model.Staff;

@MultipartConfig
@WebServlet("/Servlet_Bai_3")
public class Servlet_Bai_3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/Bai_2_3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			DateTimeConverter converter = new DateConverter(new Date());
			converter.setPattern("dd/MM/yyyy");
			ConvertUtils.register(converter, Date.class);

			Staff staff = new Staff();
			BeanUtils.populate(staff, request.getParameterMap());

			File dir = new File(request.getServletContext().getRealPath("/files"));
			if (!dir.exists()) {
				dir.mkdir();
			}

			Part photo = (Part) request.getPart("photoFile");

			String fileName = Paths.get(photo.getSubmittedFileName()).getFileName().toString();
			String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (photo.getSize() > 10 * 1024 * 1024) {
				request.setAttribute("error", "Kích thước tệp tin vượt quá 10MB");
				request.getRequestDispatcher("/views/Bai_2_3.jsp").forward(request, response);
				return;
			} else if ("jpg".equalsIgnoreCase(fileExtension) || "png".equalsIgnoreCase(fileExtension)) {
				File photoFile = new File(dir, photo.getSubmittedFileName());
				photo.write(photoFile.getAbsolutePath());

				staff.setPhotoFile(photoFile.getName());
			} else {
				request.setAttribute("error", "Chỉ cho phép tải lên tệp tin .jpg hoặc .png");
				request.getRequestDispatcher("/views/Bai_2_3.jsp").forward(request, response);
				return;
			}

			request.setAttribute("bean", staff);

			String layChuoi = Arrays.toString(staff.getHobbies());
			String catChuoi = layChuoi.substring(1, layChuoi.lastIndexOf("]")) + ".";
			request.setAttribute("soThich", catChuoi);

		} catch (Exception e) {
			e.getMessage();
		}
		request.getRequestDispatcher("/views/Form_Bai_2_3.jsp").forward(request, response);
	}

}
