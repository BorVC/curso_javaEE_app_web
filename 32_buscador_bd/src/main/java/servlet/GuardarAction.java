package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.BuscadorService;

import java.io.IOException;

@WebServlet("/GuardarAction")
public class GuardarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables recogen datos formulario guardar
		String url = request.getParameter("url");
		String tematica = request.getParameter("tematica");
		String descripcion = request.getParameter("descripcion");
		
		//Objeto resultado q pasamos al realizar guardar
		Resultado resultado = new Resultado(url,tematica,descripcion);
		
		//Objeto instancia service
		var service = new BuscadorService();
		
		//Llamada al método alta del service
		service.altaResultado(resultado);
		
	}

}
