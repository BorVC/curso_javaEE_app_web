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
		//Variables recogen datos del HTML
		String user = request.getParameter("username");
		String pwd =  request.getParameter("password");
		//Variable ReRequestDispatcher
		RequestDispatcher dispatcher;
		
		//Comprobar si el usuario y password son correctos
		if(user.equals("admin") && pwd.equals("pass")) {
			//Objeto response para el redireccionamiento a una determinada página
			response.sendRedirect("http://www.google.com");
			/*mandar párametro de usuario junto a la url
			 * response.sendRedirect("http://www.google.com?user=" + user);
			 */
		}
		else {
			dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
		
	}

}
