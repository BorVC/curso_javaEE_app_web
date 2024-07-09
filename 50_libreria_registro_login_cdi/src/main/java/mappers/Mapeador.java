package mappers;

import dao.TemasDao;
import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.inject.Inject;
import model.Cliente;
import model.Libro;
import model.Tema;

public class Mapeador {
	@Inject
	TemasDao temasDao;
	
	public  TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(),tema.getTema());
	}
	public  LibroDto libroEntityToDto(Libro libro) {
		
		//var librosService=new LibrosService();
		return new LibroDto(libro.getIsbn(),
						libro.getTitulo(),
						libro.getAutor(),
						libro.getPrecio(),
						libro.getPaginas(),
						temaEntityToDto(temasDao.findById(libro.getIdTema()))
				);
	}
	public  Libro libroDtoToEntity(LibroDto libro) {
		return new Libro(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				libro.getTemaDto().getIdTema()
				);
	}
	
	public Cliente clienteEntity(ClienteDto cliente) {
		return new Cliente(0,cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono());
	}
}
