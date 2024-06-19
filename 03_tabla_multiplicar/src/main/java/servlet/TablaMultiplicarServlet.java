package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TablaMultiplicarServlet")
public class TablaMultiplicarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Genera una cabecera en la q se le indica al navegador el tipo de contenido q se le envia
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()){
			out.println("<html><head></head><body><center>");
			out.println("<tittle><h2>TABLAS DE MULTIPLICAR</h2></tittle>");
			out.println("<table border = '1'>");
			//10 filas vertical(i = 1,2...)
			for(int i = 1; i <= 10; i++) {
				out.println("<tr>");
				//10 celdas con el resultado por cada fila ( i = 1 * j =1,2,3... hasta i = 10)
				for(int j = 1; j <= 10; j++) {
					out.println("<td>" + i * j + "</td>");
				}
				out.println("</tr>");
			}
			out.println("</table></body></html>");
		}
	}

}
