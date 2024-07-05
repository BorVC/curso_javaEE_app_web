package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tema;
import service.LibrosService;

@WebServlet("/MostrarController")
public class MostrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service = new LibrosService();
		List<Tema> temas = service.getTemas();
		request.setAttribute("temas", temas);
	}

}
