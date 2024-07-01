package service;

import dao.BuscadorDao;
import dao.UsuarioDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import model.Usuario;

public class UsuariosService {
	UsuarioDao dao = new UsuarioDao();

	public boolean loginUsuario(String usuario, String password) {
		Usuario user = dao.login(usuario,password);
		try{
			if(user != null && password.equals(user.getPassword())) {
				return true;
			}
			return false;
		}catch(NoResultException ex){
			return false;
		}catch(NonUniqueResultException ex) {
			return false;
		}
	}
}
