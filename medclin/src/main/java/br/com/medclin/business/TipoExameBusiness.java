/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoExameBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.TipoExame;
import br.com.medclin.repository.TipoExameRepository;

@Configuration
public class TipoExameBusiness implements ITipoExameBusiness {

	@Autowired
	private TipoExameRepository tipoExameRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public TipoExame atualizarTipoExame(final TipoExame tipoExame) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(tipoExame, "MOCK_MATRICULA - " + Math.random());
		return tipoExameRep.saveAndFlush(tipoExame);
	}

	@Override
	public TipoExame buscarTipoExamePorCodigo(final Short codigoTipoExame) {
		return tipoExameRep.buscarTipoExamePorCodigo(codigoTipoExame);
	}

	@Override
	public Page<TipoExame> buscarTipoExamePorNome(final PageRequest pageable, final String nomeTipoExame) {
		return tipoExameRep.buscarTipoExamePorNome(nomeTipoExame, pageable);
	}

	@Override
	public TipoExame criarTipoExame(final TipoExame tipoExame) {
		auditoriaUtil.setDadosAuditoriaCriacao(tipoExame, "MOCK_MATRICULA - " + Math.random());
		return tipoExameRep.save(tipoExame);
	}

	@Override
	public void deletarTipoExame(final Short codigoTipoExame) {
		tipoExameRep.deleteById(codigoTipoExame);
	}

	@Override
	public Page<TipoExame> listarTipoExame(final PageRequest pageable) {
		return tipoExameRep.findAll(pageable);
	}

}
