package pe.edu.usmp.java.servicio.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.usmp.java.servicio.usuario.entity.Usuario;

@Repository("iUsuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

		@Query("Select u from Usuario u where u.estado='1'")
		List<Usuario> findAllAvailable();
		
		@Query("Select u from Usuario u where upper(usuario) like upper(:usuario) and u.estado='1'")
		List<Usuario> findByUser(@Param("usuario") String usuario);
			
		
		
	
}
