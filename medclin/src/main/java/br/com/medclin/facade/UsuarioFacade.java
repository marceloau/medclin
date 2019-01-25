package br.com.medclin.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IUsuarioBusiness;
import br.com.medclin.model.Usuario;

@Configuration
public class UsuarioFacade {

	@Autowired
	private IUsuarioBusiness usuarioBusiness;

	public Page<Usuario> buscarExamePorNome(final PageRequest pageable, final String nomeUsuario) {
		return usuarioBusiness.buscarUsuarioPorNome(pageable, nomeUsuario);
	}

	public Usuario buscarExamePorCodigo(final BigInteger codigoUsuario) {
		return usuarioBusiness.buscarUsuarioPorCodigo(codigoUsuario);
	}
	
	public Usuario buscarUsuarioPorLogin(final String login) {
		return usuarioBusiness.buscarUsuarioPorLogin(login);
	}
	
	public Usuario buscarUsuarioPorEmail(final String email) {
		return usuarioBusiness.buscarUsuarioPorEmail(email);
	}

	public Page<Usuario> listarExame(final PageRequest pageable) {
		return usuarioBusiness.listarUsuario(pageable);
	}

}
