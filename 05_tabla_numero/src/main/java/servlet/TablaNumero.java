package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TablaNumero")
public class TablaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Generar cabecera
		response.setContentType("text/html");
		//Numero de filas seleccionado 
		int numero = Integer.parseInt(request.getParameter("numero"));
		try(PrintWriter out = response.getWriter()){
			out.println("<html><head></head><body><center>");
			out.println("<tittle><h2>TABLAS DE MULTIPLICAR del " + numero + "</h2></tittle>");
			out.println("<table border = '1'>");
			//10 filas  con 2 celdas(Operación y resultado)
			for(int i = 1; i <= 10 ; i++) {
				out.println("<tr>");
				out.println("<td>" + numero + "x" + i + "</td>");
				out.println("<td>" + numero * i + "</td>");
				out.println("</tr>");
			}
			out.println("</table></center>");
			out.println("<a href='numero.html'>Volver<a></body></html>");
			//NO FUNCIONA.HABRÍA Q METERLO DENTRO DE UN FORM 
			//out.println("<button type = 'submit' value = 'numero.html'/>Volver</body></html>");
		}
	}

}
