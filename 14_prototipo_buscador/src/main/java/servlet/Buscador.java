package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.ResultadosService;

@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variable recogen datos inout buscador
		String categoria = request.getParameter("categoria");
		
		//Objeto q instancia el service
		var service = new ResultadosService();
			List<Resultado> resultados = service.mostrarResultadoPorCategoria(categoria);
			//Guardar objeto en un atributo
			request.setAttribute("paginas", resultados);
			//transferir control a un JSP
			request.getRequestDispatcher("mostrarResultado.jsp").forward(request, response);
	}

}
