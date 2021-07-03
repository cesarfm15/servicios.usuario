package pe.edu.usmp.java.servicio.usuario.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.usmp.java.servicio.usuario.entity.Usuario;
import pe.edu.usmp.java.servicio.usuario.service.IUserValidatorService;
import pe.edu.usmp.java.servicio.usuario.service.IUsuarioService;
import pe.edu.usmp.java.servicio.usuario.utils.ApiUnprocessableEntity;

@Slf4j
@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private IUsuarioService iUsuarioService;
	
	
	@Autowired
	@Qualifier("userValidatorServiceImpl")
	private IUserValidatorService iUserValidatorService;
	
	
	@GetMapping("/")
	public List<Usuario> getAll(){
		return iUsuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario getById(@PathVariable Integer id) {
		log.info("getById");
		return iUsuarioService.findById(id);
	}
	
	@GetMapping("/listaUsuarios")
	public List<Usuario> getByUser(@RequestParam String user){
		return iUsuarioService.findByUser(user);
	}
	
	@PostMapping()
	public Usuario post(@RequestBody Usuario usuario) throws ApiUnprocessableEntity {
		this.iUserValidatorService.validator(usuario);
		return iUsuarioService.insert(usuario);
		/*if(!usuario.getCelular().toString().isEmpty()) {
			return iUsuarioService.insert(usuario);
		}else {
			throw new RuntimeException("Celular no puede ser vacio");	
		}*/
		
	}
	
	@PutMapping("/{id}")
	public Usuario put(@PathVariable Integer id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return iUsuarioService.insert(usuario);		
	}
	
	@DeleteMapping("/{id}")
	public Usuario delete(@PathVariable Integer id) {
		return iUsuarioService.delete(Usuario.builder().id(id).build());
	}
	
}
