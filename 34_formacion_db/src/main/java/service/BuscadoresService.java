package service;

import java.util.List;
import java.util.Optional;

import dao.BuscadorDao;
import model.Curso;

public class BuscadoresService {

	BuscadorDao dao = new BuscadorDao();
	//Si el nombre del curso ya existe
	public boolean guardarCurso(Curso curso) {
		if(dao.buscarPorNombre(curso.getNombre()) == null) {
			dao.guardar(curso);
			return true;
		}
		return false;
	}
	
	public Optional <Curso> eliminarCurso(String nombre){
		Curso curso = dao.buscarPorNombre(nombre); 
		if(curso != null) {
			dao.eliminar(nombre);
		}
		return curso!=null?Optional.of(curso):Optional.empty();
	}
	
	public List<Curso> buscarCurso(int precio){
		return dao.buscarPorPrecio(precio).stream()
				.filter(c -> c.getPrecio() <= precio)
				.toList();
	}
	
	public boolean modificarCurso(String nombre,int duracion) {
		if(dao.buscarPorNombre(nombre) != null) {
			dao.modificarDuracion(nombre,duracion);
			return true;
		}
		return false;
	}
}
