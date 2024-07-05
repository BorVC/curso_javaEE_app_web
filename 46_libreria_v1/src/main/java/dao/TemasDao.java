package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;

public class TemasDao {
	private static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreria_v1_PU");
		eManager= factory.createEntityManager();
	}
	
	public List<Tema> mostrarTemas(){
		TypedQuery<Tema> query = eManager.createNamedQuery("Tema.mostrarTemas",Tema.class);
		return query.getResultList();
	}
}
