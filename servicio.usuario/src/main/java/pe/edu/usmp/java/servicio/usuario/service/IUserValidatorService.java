package pe.edu.usmp.java.servicio.usuario.service;

import org.springframework.stereotype.Service;

import pe.edu.usmp.java.servicio.usuario.entity.Usuario;
import pe.edu.usmp.java.servicio.usuario.utils.ApiUnprocessableEntity;


/*
 * (i) para la validacion de los datos recibidos para la creacion de usuarios*/
@Service
public interface IUserValidatorService {

	void validator(Usuario request) throws ApiUnprocessableEntity;
	
}
