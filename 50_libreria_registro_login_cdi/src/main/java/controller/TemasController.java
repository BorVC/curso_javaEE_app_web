package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LibrosService;
import service.LibrosServiceImpl;

@WebServlet("/TemasController")
public class TemasController extends HttpServlet {
	@Inject
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LibrosService service=new LibrosServiceImpl();
		request.setAttribute("temas", service.getTemas());
	}

}
