package service;

import dao.ClientesDao;
import dtos.ClienteDto;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mappers.Mapeador;


@Named("clienteService1")
public class ClientesServiceImpl implements ClientesService {
 @Inject
 @Named("cliente1")
 ClientesDao clientesDao;
 @Inject
 Mapeador mapeador;
 
 @Override
public boolean autenticar(String usuario, String password) {
		return clientesDao.login(usuario, password) != null;
 }
 
 @Override
public boolean guardarCliente(ClienteDto cliente) {
	 if(clientesDao.findByUsu(cliente.getUsuario()) != null) {
		 return false;
	 }
	 clientesDao.save(mapeador.clienteEntity(cliente));
	 return true;
 }
}
