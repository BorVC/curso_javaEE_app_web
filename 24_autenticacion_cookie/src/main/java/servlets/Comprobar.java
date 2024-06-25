package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 @WebServlet
public class Comprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Cookie todas [] = request.getCookies();
		if(todas != null) {
			for(Cookie ck : todas) {
				if(ck.getName().equals("usuarioVisita")) {
					dispatcher = request.getRequestDispatcher("conocido.jsp");
				}
				dispatcher = request.getRequestDispatcher("Login.java");
			}
		}else {
			dispatcher = request.getRequestDispatcher("Login.java");
		}
		dispatcher.forward(request, response);
	}

}
