package servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BuscadorService;

import java.io.IOException;

@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//Variable del formulario
		int id = Integer.parseInt(request.getParameter("id"));
				
		//Objeto intancia service
		var service = new BuscadorService();
				
		//Llamada al método
		service.eliminarResultado(id);*/
		BuscadorService service=new BuscadorService();
		service.eliminarResultado(Integer.parseInt(request.getParameter("idResultado")));
	}

}
