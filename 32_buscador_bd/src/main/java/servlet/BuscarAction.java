package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

@WebServlet("/BuscarAction")
public class BuscarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//Variable del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Objeto intancia service
		var service = new BuscadorService();
		
		//Lista en la que se guardan los resultados de la busqueda
		Resultado resultado = service.buscarResultadoPorId(id);*/
		
		BuscadorService service=new BuscadorService();
		Resultado resultado=service.buscarResultadoPorId(Integer.parseInt(request.getParameter("idResultado")));
		
		//Atributo de petición
		request.setAttribute("resultado", resultado);
		
		
		
	}

}
