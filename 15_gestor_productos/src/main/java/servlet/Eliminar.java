package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductosService;

import java.io.IOException;

@WebServlet
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variable q guarda el dato q viene del input del form
		String nombre = request.getParameter("nombre");
		
		//Objeto q instancia el service
		var service = new ProductosService();
		
		//Llamada al método del service
		service.eliminar(nombre);
		
		//Transferir control al JSP
		request.getRequestDispatcher("gestorProductos.html").forward(request, response);
	}

}
