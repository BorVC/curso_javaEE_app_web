package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("operation");
		String urlVista = "";
		switch(op) {
		case "doMostrar":
			request.getRequestDispatcher("MostrarController").include(request, response);
			urlVista = "buscador.jsp";
			break;
		case "doBuscar":
			request.getRequestDispatcher("BuscarController").forward(request, response);
			return;//En peticiones AJAX la respuesta se lleva a cabo en el servlet controlador
		default:
			urlVista = "index.html";
			
		}
		//Reenvio de peticiones dependiendo de l opción seleccionada
		request.getRequestDispatcher(urlVista).forward(request, response);
	}
	

}
