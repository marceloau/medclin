package br.com.medclin.seguranca;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.medclin.model.Usuario;

public class UserService {
	
	public static Usuario authenticated() {
		try {
			return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
