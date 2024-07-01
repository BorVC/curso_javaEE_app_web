package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BuscadoresService;

import java.io.IOException;

@WebServlet("/EliminaAction")
public class EliminaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuscadoresService service = new BuscadoresService();
		service.eliminarCurso(request.getParameter("nombre"));
	}

}
