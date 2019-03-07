package br.com.medclin.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.model.Usuario;
import br.com.medclin.seguranca.JWTUtil;
import br.com.medclin.seguranca.UserService;

@RestController
@RequestMapping(value="/seguranca")
public class SegurancaResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value="/atualizar_token", method=RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
	Usuario user = UserService.authenticated();
	String token = jwtUtil.generateToken(user);
	response.addHeader("Authorization", "Bearer " + token);
	return ResponseEntity.noContent().build();
	}

}
