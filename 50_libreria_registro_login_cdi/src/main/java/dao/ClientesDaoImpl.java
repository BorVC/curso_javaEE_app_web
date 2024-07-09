package dao;

import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Cliente;
import model.Libro;


@Named("cliente1")
public class ClientesDaoImpl implements ClientesDao {
	static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		eManager=factory.createEntityManager();
	}

	@Override
	public void save(Cliente cliente) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.persist(cliente);
		tx.commit();
	}
	
	@Override
	public Cliente login(String usuario,String password) {
		String jpql="select c from Cliente c where c.cliente=?1 and c.password=?2";
		TypedQuery<Cliente> query=eManager.createQuery(jpql,Cliente.class);
		query.setParameter(1, usuario);
		query.setParameter(2, password);
		return query.getResultList().stream()
				.findFirst()
				.orElse(null);
	}

	@Override
	public Cliente findByUsu(String usuario) {
		return eManager.find(Cliente.class, usuario);
	}
}
