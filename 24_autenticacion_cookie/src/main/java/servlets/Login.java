package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.AutenticacionService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("username");
		String pwd=request.getParameter("password");
		RequestDispatcher dispatcher;
		var service=new AutenticacionService();
		//llamada al método que crea la cookie
		crearCookie(response,user);
		if(service.autenticar(user, pwd)) {
			//creamos la ficha del usuario y la guardamos en un atributo
			//de petición para que la pueda recuperar la página JSP
			Ficha ficha=service.fichaUsuario(user);
			request.setAttribute("ficha", ficha);
			dispatcher=request.getRequestDispatcher("bienvenida.jsp");
		}else {
			dispatcher=request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
		
	}
	private void crearCookie(HttpServletResponse response,String user) {
		String datosUsu = user;
		Cookie ck = new Cookie("usuarioVisita", datosUsu);
		ck.setMaxAge(100_000);
		response.addCookie(ck);
	}

}
