package pe.edu.usmp.java.servicio.usuario.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*Excepcion personalizada de status 401
 * */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiUnauthorized(String message) {
		super(message);
	}
	
}

