package pe.edu.usmp.java.servicio.usuario.service;

import org.springframework.stereotype.Component;

import pe.edu.usmp.java.servicio.usuario.entity.Usuario;
import pe.edu.usmp.java.servicio.usuario.utils.ApiUnprocessableEntity;

@Component("userValidatorServiceImpl")
public class UserValidatorServiceImpl implements IUserValidatorService{

	@Override
	public void validator(Usuario request) throws ApiUnprocessableEntity {
		
		if(request.getNombres()==null || request.getNombres().isEmpty()) {
			this.message("Los nombres son obligatorios");
		}
		
		if(request.getNombres().length()<5) {
			this.message("Ingrese sus 2 nombres");
		}		
		
		if(request.getApellidos()==null || request.getApellidos().isEmpty()) {
			message("Los apellidos son obligatorios");
		}
		
		if(request.getApellidos().length()<5) {
			message("Los nombres son obligatorios");
		}
		
		if(request.getCelular()==null) {
			message("El numero de telefono es requerido");
		}
		
		if(request.getContrasena()==null || request.getContrasena().isEmpty()) {
			message("La contraseña es requerida");
		}
		
		if(request.getContrasena().length()<8) {
			message("la contraseña tiene que ser de 8 digitos a más");
		}
		
		
	}
	
	private void message(String message) throws ApiUnprocessableEntity{
		
		throw new ApiUnprocessableEntity(message);
	}

}
