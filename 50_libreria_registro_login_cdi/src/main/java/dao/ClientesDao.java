package dao;

import model.Cliente;

public interface ClientesDao {

	void save(Cliente cliente);

	Cliente login(String usuario, String password);
	
	Cliente findByUsu(String usu);

}