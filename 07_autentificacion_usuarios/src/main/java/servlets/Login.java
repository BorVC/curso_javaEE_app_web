package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables recogen datos del HTML con objeto request
		String user = request.getParameter("username");
		String pwd =  request.getParameter("password");
		//Variable ReRequestDispatcher
		RequestDispatcher dispatcher;
		
		//Comprobar si el usuario y password son correctos
		if(user.equals("admin") && pwd.equals("pass")) {
			dispatcher=request.getRequestDispatcher("Bienvenida");
		}
		else {
			dispatcher=request.getRequestDispatcher("Error");
		}
		dispatcher.forward(request, response);
	}

}
