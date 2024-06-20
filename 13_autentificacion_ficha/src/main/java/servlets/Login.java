package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.AutentifiacionService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables recogen datos del HTML con objeto request
		String user = request.getParameter("username");
		String pwd =  request.getParameter("password");
		//Variable ReRequestDispatcher
		RequestDispatcher dispatcher;
		//Objeto q instacia el service
		var service = new AutentifiacionService();
		//Comprobar si el usuario y password son correctos
		//if(user.equals("admin") && pwd.equals("pass")) {
		if(service.autentificar(user, pwd)) {
			//creamos ficha del usuario y la guardamos en un atributo
			//de petición para q la pueda recuperar la página JSP
			//Ficha ficha = new Ficha(user,80,"test@gmail.com");
			Ficha ficha = service.fichaUsuario(user);
			//Guardar objeto en un atributo
			request.setAttribute("ficha", ficha);
			//transferir control a un JSP
			dispatcher=request.getRequestDispatcher("bienvenida.jsp");
		}
		else {
			dispatcher=request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

}
