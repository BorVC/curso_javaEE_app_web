package service;

import java.util.List;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;

public class LibrosService {

	LibrosDao libroDao = new LibrosDao();
	TemasDao temaDao = new TemasDao();
	
	public List<Libro> librosPorTema(int idTema){
		if(idTema == 0) {
			return libroDao.findAll();
		}else {
			return libroDao.findByIdTema(idTema);
		}
	}
	
	public List<Tema> getTemas(){
		return temaDao.mostrarTemas();
	}
	
	
}
