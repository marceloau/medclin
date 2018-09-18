/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoPlanoSaudeBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.TipoPlanoSaude;
import br.com.medclin.repository.TipoPlanoSaudeRepository;

@Configuration
public class TipoPlanoSaudeBusiness implements ITipoPlanoSaudeBusiness {

	@Autowired
	private TipoPlanoSaudeRepository tipoPlanoSaudeRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public TipoPlanoSaude atualizarTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(tipoPlanoSaude, "MOCK_MATRICULA - " + Math.random());
		return tipoPlanoSaudeRep.saveAndFlush(tipoPlanoSaude);
	}

	@Override
	public TipoPlanoSaude buscarTipoPlanoSaudePorCodigo(final Short codigoTipoPlanoSaude) {
		return tipoPlanoSaudeRep.buscarTipoPlanoSaudePorCodigo(codigoTipoPlanoSaude);
	}

	@Override
	public Page<TipoPlanoSaude> buscarTipoPlanoSaudePorNome(final PageRequest pageable,
			final String nomeTipoPlanoSaude) {
		return tipoPlanoSaudeRep.buscarTipoPlanoSaudePorNome(nomeTipoPlanoSaude, pageable);
	}

	@Override
	public TipoPlanoSaude criarTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude) {
		auditoriaUtil.setDadosAuditoriaCriacao(tipoPlanoSaude, "MOCK_MATRICULA - " + Math.random());
		return tipoPlanoSaudeRep.save(tipoPlanoSaude);
	}

	@Override
	public void deletarTipoPlanoSaude(final Short codigoTipoPlanoSaude) {
		tipoPlanoSaudeRep.deleteById(codigoTipoPlanoSaude);
	}

	@Override
	public Page<TipoPlanoSaude> listarTipoPlanoSaude(final PageRequest pageable) {
		return tipoPlanoSaudeRep.findAll(pageable);
	}

}
