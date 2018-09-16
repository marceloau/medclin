package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoContatoBusiness;
import br.com.medclin.model.TipoContato;

@Configuration
public class TipoContatoFacade {

	@Autowired
	private ITipoContatoBusiness tipoContatoBusiness;

	public TipoContato atualizarTipoContato(final TipoContato TipoContato) {
		return tipoContatoBusiness.atualizarTipoContato(TipoContato);
	}

	public Page<TipoContato> buscarTipoContatoPorNome(final PageRequest pageable, final String nomeTipoContato) {
		return tipoContatoBusiness.buscarTipoContatoPorNome(pageable, nomeTipoContato);
	}

	public Iterable<TipoContato> buscarTipoContatoPorCodigo(final Short codigoTipoContato) {
		return tipoContatoBusiness.buscarTipoContatoPorCodigo(codigoTipoContato);
	}

	public TipoContato criarTipoContato(final TipoContato TipoContato) {
		return tipoContatoBusiness.criarTipoContato(TipoContato);
	}

	public void deletarTipoContato(final Short codigoTipoContato) {
		tipoContatoBusiness.deletarTipoContato(codigoTipoContato);
	}

	public Page<TipoContato> listarTipoContato(final PageRequest pageable) {
		return tipoContatoBusiness.listarTipoContato(pageable);
	}

}
