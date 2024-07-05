package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;

public class LibrosDao {
	
	private static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreria_v1_PU");
		eManager= factory.createEntityManager();
	}
	
	public List<Libro> findAll(){
		TypedQuery<Libro> query = eManager.createNamedQuery("Libro.findAll",Libro.class);
		return query.getResultList();
	}

	public List<Libro> findByIdTema(int idTema){
		TypedQuery<Libro> query = eManager.createNamedQuery("Libro.findByIdTema",Libro.class);
		query.setParameter(1, idTema);
		return query.getResultList();
	}
	
	public Libro findLibro(int isbn) {
		TypedQuery<Libro> query = eManager .createNamedQuery("Libro.agregarLibro", Libro.class);
		query.setParameter(1, isbn);
		try {
			return query.getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}
	}
}
