package Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies {

	public static Cookie add(String name, String value, HttpServletResponse response, int hours) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 3600);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}

	public static String get(String name, HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return "";
	}

	// public static void main(String[] args) {
	// int number = (int) (Math.random() * 900000) + 100000;
	// System.out.println(number);
	// int i = 461246;
	// if (i!=number) {
	// System.out.println("no");
	// return;
	// }
	// System.out.println("ok");
	// }
}
