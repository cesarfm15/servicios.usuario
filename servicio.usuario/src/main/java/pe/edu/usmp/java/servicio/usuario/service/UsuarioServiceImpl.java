package pe.edu.usmp.java.servicio.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



import pe.edu.usmp.java.servicio.usuario.entity.Usuario;
import pe.edu.usmp.java.servicio.usuario.repository.IUsuarioRepository;
import pe.edu.usmp.java.servicio.usuario.utils.BCrypt;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	@Qualifier("iUsuarioRepository")
	IUsuarioRepository iUsuarioRepository;
	
	
	@Override
	public List<Usuario> findAll() {
		return iUsuarioRepository.findAllAvailable();
	}

	@Override
	public Usuario findById(Integer id) {
		return iUsuarioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> findByUser(String user) {
		user = "%"+((user==null)?"":user)+"%";
		return iUsuarioRepository.findByUser(user);
	}

	@Override
	public Usuario insert(Usuario usuario) {
		usuario.setContrasena(BCrypt.hashpw(usuario.getContrasena(), BCrypt.gensalt()));
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public Usuario delete(Usuario usuario) {
		Usuario oUsuario = iUsuarioRepository.findById(usuario.getId()).orElse(null);
		
		if(oUsuario!=null) {
			oUsuario.setEstado("0");
			iUsuarioRepository.save(oUsuario);
		}
		return oUsuario;
	}

}
