package dao;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Usuario;

public class UsuarioDao {

	private static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("buscador");
		eManager=factory.createEntityManager();
	}
	
	public Usuario login (String usuario, String contraseña) {
		String jpql = "select u from Usuario u where u.usuario=:usu and u.contraseña =:con";
		TypedQuery<Usuario> query= eManager.createQuery(jpql, Usuario.class);
		query.setParameter("usu", usuario);
		query.setParameter("con", contraseña);
		return query.getResultList().stream()
				.findFirst()
				.orElse(null);
	}
}
