/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import br.com.medclin.business.interfaces.IUsuarioBusiness;
import br.com.medclin.model.Usuario;
import br.com.medclin.repository.UsuarioRepository;

@Configuration
public class UsuarioBusiness implements IUsuarioBusiness {

	/** The usuario rep. */
	@Autowired
	private UsuarioRepository usuarioRep;

	@Override
	public Page<Usuario> buscaUsuarioPorNome(Integer page, Integer size, String nomeParametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscaUsuarioPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscaUsuarioPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscaUsuarioPorCodigo(BigInteger codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
