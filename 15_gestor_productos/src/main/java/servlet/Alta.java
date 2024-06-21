package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

@WebServlet("/Alta")
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables recogen datos del formulario de alta
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String categoria = request.getParameter("categoria");
		
		Producto producto = new Producto(nombre,precio,categoria);
		
		//Objeto que instancia el service
		var service = new ProductosService();
		//Llamada al método alta() del service
		service.nuevo(producto);
		//mostrar pagina de inicio una vez hecho
		request.getRequestDispatcher("getorProductos.html").forward(request, response);
		
	}

}
