package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variable guarda input formulario
		String categoria = request.getParameter("categoria");
		
		//Objeto q instancia el service
		var service = new ProductosService();
		//Lista en la que se guardan los resultados de la busqueda
		List<Producto> productos = service.buscarPorCategoria(categoria);
		//Guarda objeto en un atributo para el JSP lo pueda encontrar
		request.setAttribute("productos", productos);
		//transferir control a JSP
		request.getRequestDispatcher("productosPorCategoria.jsp").forward(request, response);
	}

}
