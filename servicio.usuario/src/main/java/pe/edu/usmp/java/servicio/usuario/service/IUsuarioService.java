package pe.edu.usmp.java.servicio.usuario.service;

import java.util.List;

import pe.edu.usmp.java.servicio.usuario.entity.Usuario;

public interface IUsuarioService {

	List<Usuario> findAll();
	
	Usuario findById(Integer id);
	
	List<Usuario> findByUser(String user);
	
	Usuario insert(Usuario usuario);
	
	Usuario delete(Usuario usuario);
	
	
	
}
