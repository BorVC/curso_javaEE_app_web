package servlets;

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
		String urlVista="";
		String operation=request.getParameter("operation");
		urlVista=switch(operation) {
			case "doGuardar"->{
				request.getRequestDispatcher("AltaAction").include(request, response);
				yield "inicio.html";
			}
			case "doEliminar"->{
				request.getRequestDispatcher("EliminarAction").include(request, response);
				yield "inicio.html";
			}
			case "doBuscar"->{
				request.getRequestDispatcher("BuscarAction").include(request, response);
				yield "resultado.jsp";
			}
			case "doModificar"->{
				request.getRequestDispatcher("BuscarResultadosAction").include(request, response);
				yield "inicio.html";
			}
			case "toGuardar"->"guardar.jsp";
			case "toBuscar"->"buscar.jsp";
			case "toEliminar"->"eliminar.jsp";
			default ->"inicio.html";
		};
		//transferimos el control a la vista definitiva
		request.getRequestDispatcher(urlVista).forward(request, response);
	}

}
