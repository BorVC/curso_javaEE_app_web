package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Resultado;

public class BuscadorService {
	
	private EntityManager eManager;
	public BuscadorService() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("buscador");
		eManager=factory.createEntityManager();
	}
	
	public void altaResultado(Resultado resultado) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.persist(resultado);
		tx.commit();
	}
	
	public Resultado buscarResultadoPorId(int idResultado) {
		return eManager.find(Resultado.class, idResultado);
	}
	
	public void eliminarResultado(int idResultado) {
		Resultado resultado=buscarResultadoPorId(idResultado);
		if(resultado!=null) {
			EntityTransaction tx=eManager.getTransaction();
			tx.begin();
			eManager.remove(resultado);
			tx.commit();
		}
	}
	
	public List<Resultado> resultadoPorTematica(String tematica){
		String jpql = "select r from resultado where r.tematica=:tem";
		TypedQuery<Resultado> query = eManager.createQuery(jpql, Resultado.class);
		query.setParameter("tem", tematica);
		return query.getResultList();
	}
	
	public Resultado buscarPorUrl(String url) {
		String jpql = "select r from resultado where r.url=:url";
		TypedQuery<Resultado> query = eManager.createQuery(jpql, Resultado.class);
		query.setParameter("url", url);
		//Opcion A
		/*return query.getResultList().stream()
				.findFirst()
				.orElse(null);*/
		
		//Opción B
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return query.getResultList().get(0);
		}
		
	}
}
