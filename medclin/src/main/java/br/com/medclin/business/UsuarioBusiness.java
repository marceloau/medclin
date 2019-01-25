/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IUsuarioBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.Usuario;
import br.com.medclin.repository.UsuarioRepository;

@Configuration
public class UsuarioBusiness implements IUsuarioBusiness {

	/** The usuario rep. */
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Page<Usuario> buscarUsuarioPorNome(final PageRequest pageable, String nomeParametro) {
		return cloneUtil.cloneListaUsuario(usuarioRep.buscarUsuarioPorNome(nomeParametro, pageable));
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		return cloneUtil.cloneUsuario(usuarioRep.buscarUsuarioPorEmail(email));
	}

	@Override
	public Usuario buscarUsuarioPorLogin(String login) {
		return cloneUtil.cloneUsuario(usuarioRep.buscarUsuarioPorLogin(login));
	}

	@Override
	public Usuario buscarUsuarioPorCodigo(BigInteger codigo) {
		return cloneUtil.cloneUsuario(usuarioRep.buscarUsuarioPorCodigoPessoa(codigo));
	}

	@Override
	public Page<Usuario> listarUsuario(final PageRequest pageable) {
		return cloneUtil.cloneListaUsuario(usuarioRep.findAll(pageable));
	}
}
