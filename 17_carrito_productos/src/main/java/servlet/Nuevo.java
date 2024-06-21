package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;


@WebServlet("/Nuevo")
public class Nuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Objeto HttpSession
		HttpSession miSesion = request.getSession();
		
		//Variables q guardan los input del formulario
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String categoria = request.getParameter("categoria");
		
		//Objeto en el q guardar los productos
		List<Producto> productos = new ArrayList<>();
		
		if(miSesion.getAttribute("carrito") != null) {
			productos = (List<Producto>)miSesion.getAttribute("carrito");
		}
		productos.add(new Producto(nombre,precio,categoria));
		
		miSesion.setAttribute("carrito", productos);

		//Mostrar página de inicio una vez hecho
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
