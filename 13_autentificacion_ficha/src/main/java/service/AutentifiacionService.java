package service;

import java.util.List;

import model.Ficha;

public class AutentifiacionService {
	//Constantes
	private final String USER = "admin";
	private final String PASSWORD = "curso";
	
	//Lista con fichas inventadas q podrían estar en un a base de datos
	List<Ficha>fichas = List.of(
			new Ficha("ar",19,"aa@gmail.com"),
			new Ficha("admin",24,"admin@gmail.com"),
			new Ficha("jose",49,"jose@gmail.com"),
			new Ficha("hup",35,"hup@gmail.com")
			);

	//Métodos
	public boolean autentificar(String usuario,String password) {
		return usuario.equals(USER) && password.equals(PASSWORD);
	}
	
	public Ficha fichaUsuario(String usuario) {
		/*for(Ficha ficha : fichas) {
			if(usuario.equals(ficha.getUsuario())) {
				return ficha;
			}
		}
		return null;*/
		//Funcional
		return fichas.stream()
				.filter(f -> f.equals(usuario))
				.findFirst()
				.orElse(null);
	}
}
