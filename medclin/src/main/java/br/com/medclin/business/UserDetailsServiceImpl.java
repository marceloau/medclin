package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.medclin.model.Usuario;
import br.com.medclin.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** The usuario rep. */
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		final Usuario usuario = usuarioRep.buscarUsuarioPorLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException(login);
		}
		
		return new Usuario(usuario);
	}

}
