package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Objeto HttpSession
		HttpSession miSesion = request.getSession();
		
		//Atributo de sesión 
		List<Producto> productos = (List<Producto>) miSesion.getAttribute("carrito");
		
		//Eliminar producto
		productos.removeIf(p -> p.getNombre().equals(request.getParameter("nombre")));
		
		//Tranferir el control al JSP
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		
		
	}

}
