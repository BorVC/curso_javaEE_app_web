package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Comprueba")
public class Comprueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variable RequestDispatcher
		RequestDispatcher dispatcher;
		
		//Comprobar si se pasa un númeo o un texto
		 try {
	            Integer.parseInt(request.getParameter("numero"));
	            dispatcher=request.getRequestDispatcher("tablanumero.jsp");
	            //request.getRequestDispatcher("tablanumero.jsp").forward(request, response);
	        }
	        catch (NumberFormatException ex){
	        	dispatcher=request.getRequestDispatcher("notablanumero.jsp");
	        	//request.getRequestDispatcher("notablanumero.jsp").forward(request, response);
	        }
		 dispatcher.forward(request, response);
	}

}
