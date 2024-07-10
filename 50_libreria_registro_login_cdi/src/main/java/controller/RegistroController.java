package controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ClientesService;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dtos.ClienteDto;

@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {	
	@Inject
	ClientesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		
		ClienteDto dto = new ClienteDto(0,usuario,password,email,telefono);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(service.guardarCliente(dto));
	}

}
