/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoContatoBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.TipoContato;
import br.com.medclin.repository.TipoContatoRepository;

@Configuration
public class TipoContatoBusiness implements ITipoContatoBusiness {

	@Autowired
	private TipoContatoRepository tipoContatoRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public TipoContato atualizarTipoContato(final TipoContato tipoContato) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(tipoContato, "MOCK_MATRICULA - " + Math.random());
		return tipoContatoRep.saveAndFlush(tipoContato);
	}

	@Override
	public Iterable<TipoContato> buscarTipoContatoPorCodigo(final Short codigoTipoContato) {
		return tipoContatoRep.buscarTipoContatoPorCodigo(codigoTipoContato);
	}

	@Override
	public Page<TipoContato> buscarTipoContatoPorNome(final PageRequest pageable, final String nomeTipoContato) {
		return tipoContatoRep.buscarTipoContatoPorNome(nomeTipoContato, pageable);
	}

	@Override
	public TipoContato criarTipoContato(final TipoContato tipoContato) {
		auditoriaUtil.setDadosAuditoriaCriacao(tipoContato, "MOCK_MATRICULA - " + Math.random());
		return tipoContatoRep.save(tipoContato);
	}

	@Override
	public void deletarTipoContato(final Short codigoTipoContato) {
		tipoContatoRep.deleteById(codigoTipoContato);
	}

	@Override
	public Page<TipoContato> listarTipoContato(final PageRequest pageable) {
		return tipoContatoRep.findAll(pageable);
	}

}
