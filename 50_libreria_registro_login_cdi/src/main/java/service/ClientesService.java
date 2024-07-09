package service;

import dtos.ClienteDto;

public interface ClientesService {

	boolean autenticar(String usuario, String password);

	boolean guardarCliente(ClienteDto cliente);

}