package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String usuario = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try(PrintWriter out = response.getWriter()){
			out.println("<html><head></head><body><center>");
			out.println("<h2>El usuario " + usuario + "</h2></br>");
			out.println("<h2>con contraseña " + pass + "</h2></br>");
			out.println("<h2>NO es valido</h2></br>");
			out.println("<a href = 'login.html'>Volver</a>");
			out.println("</center></body></html>");
		}
	}

}
