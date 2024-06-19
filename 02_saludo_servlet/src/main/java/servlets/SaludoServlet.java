package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/SaludoServlet")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Genera una cabecera en la q se le indica al navegador el tipo de contenido q se le envia
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()){
			out.println("<html><head></head><body><center>");
			for(int i = 1; i<=6;i++) {
				out.println("<h" + i + ">Mi primer servlet</h" + i + ">");
			}
			out.println("</center></body></html>");
		}
	}

}
