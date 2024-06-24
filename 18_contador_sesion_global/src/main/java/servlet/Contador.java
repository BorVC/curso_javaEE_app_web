package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Contador")
public class Contador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos el atributo q contiene el valor del contador 
		//se incrementa y se vuelve a guadar.Después se trranfiere la petición 
		//a la página resultado.jsp
		int contador = 1;
		int global = 1;
		
		HttpSession misession = request.getSession();
		ServletContext context = request.getServletContext();
		//Contador individual
		if(misession.getAttribute("contador")!=null) {
			contador = (Integer)misession.getAttribute("contador");
			contador++;
		}
		
		//Contador global
		if(context.getAttribute("global") != null) {
			global = (Integer)context.getAttribute("golbal");
			global++;
		}
		//Actuliza la variable contador
		misession.setAttribute("contador", contador);
		context.setAttribute("global", global);
		
		//Transferir petción al JSP
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

}
