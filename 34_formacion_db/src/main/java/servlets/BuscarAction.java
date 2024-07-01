package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.BuscadoresService;

@WebServlet("/BuscarAction")
public class BuscarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuscadoresService service = new BuscadoresService();
		int precio = Integer.parseInt(request.getParameter("precio"));
		List<Curso> cursos = service.buscarCurso(precio);
		request.setAttribute("cursos", cursos);
	}

}
