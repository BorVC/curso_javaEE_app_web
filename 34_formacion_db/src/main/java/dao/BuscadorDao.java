package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Curso;


public class BuscadorDao {

	private static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("buscador");
		eManager=factory.createEntityManager();
	}
	
	public void guardar (Curso curso) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		try {
			eManager.persist(curso);
			tx.commit();
		}catch(Exception ex) {
			tx.rollback();
		}
	}
	
	public void eliminar (String nombre) {
		eManager.remove(nombre);
	}
	
	public List<Curso> buscarPorPrecio(int precio){
		String jpql = "select c from Curso c where c.precio=:prec";
		TypedQuery<Curso> query= eManager.createQuery(jpql, Curso.class);
		query.setParameter("prec", precio);
		return query.getResultList();
	}
	
	public Curso buscarPorNombre(String nombre){
		String jpql = "select c from Curso c where c.nombre=:nom";
		TypedQuery<Curso> query= eManager.createQuery(jpql, Curso.class);
		query.setParameter("nom", nombre);
		return query.getSingleResult();
	}
	
	public void modificarDuracion(String nombre ,int duracion) {
		String jpql = "update Curso c where c.nombre=:nom set c.duracion=:dur ";
		TypedQuery<Curso> query= eManager.createQuery(jpql, Curso.class);
		query.setParameter("nom", nombre);
		query.setParameter("dur", duracion);
	}
	
}
