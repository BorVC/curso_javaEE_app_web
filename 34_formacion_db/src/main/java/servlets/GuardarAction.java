package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.BuscadoresService;

@WebServlet("/GuardarAction")
public class GuardarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Implementación del service
		BuscadoresService service = new BuscadoresService();
		//Variables guardan valores pasados por input
		String nombre = request.getParameter("nombre");
		String tematica = request.getParameter("tematica");
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		//Objeto Curso
		Curso curso = new Curso(0,nombre,tematica,duracion,precio);
		//Llamada a método del service
		service.guardarCurso(curso);
		
	}

}
