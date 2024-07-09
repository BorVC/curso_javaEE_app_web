package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ClientesService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	@Inject
	ClientesService service;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = service.autenticar(request.getParameter("usuario"), request.getParameter("password"));
		//guardamos el resultado de la autenticación en un atributo de petición
		request.setAttribute("autenticado", result);
		//Si el usuario es autenticado,lo guardamos en un atributo de sesión
		if(result) {
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
		}
	}

}
