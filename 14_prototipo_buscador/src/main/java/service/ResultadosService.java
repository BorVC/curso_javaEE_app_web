package service;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;

public class ResultadosService {
	static List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es/","libros","Libros y más"),
			new Resultado("http://www.mybook.com/","libros","librería de temas varios"),
			new Resultado("http://www.game.es/","juegos","Juegos variados"),
			new Resultado("http://www.music.es/","música","Lamejor música"),
			new Resultado("http://www.tech.com/","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es/","juegos","Juegos on-line")
			)); 
	//Métodos
	public List<Resultado> mostrarResultadoPorCategoria(String categoria) {
		//tradicional
		/*List<Resultado>aux = new ArrayList<Resultado>();
		for(Resultado resultado : resultados) {
			if(resultado.getCategoria().equals(categoria)) {
				aux.add(resultado);
			}
		}
		return aux;*/
		//Funcional
		return resultados.stream()
				.filter(r->r.getCategoria().equals(categoria))
				.toList();
				
	}

}
