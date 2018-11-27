/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoMedicamentoBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.TipoMedicamento;
import br.com.medclin.repository.TipoMedicamentoRepository;

@Configuration
public class TipoMedicamentoBusiness implements ITipoMedicamentoBusiness {

	@Autowired
	private TipoMedicamentoRepository tipoMedicamentoRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public TipoMedicamento atualizarTipoMedicamento(final TipoMedicamento tipoMedicamento) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(tipoMedicamento, "MOCK_MATRICULA - " + Math.random());
		return tipoMedicamentoRep.saveAndFlush(tipoMedicamento);
	}

	@Override
	public TipoMedicamento buscarTipoMedicamentoPorCodigo(final Short codigoTipoMedicamento) {
		return tipoMedicamentoRep.buscarTipoMedicamentoPorCodigo(codigoTipoMedicamento);
	}

	@Override
	public Page<TipoMedicamento> buscarTipoMedicamentoPorNome(final PageRequest pageable,
			final String nomeTipoMedicamento) {
		return tipoMedicamentoRep.buscarTipoMedicamentoPorNome(nomeTipoMedicamento, pageable);
	}

	@Override
	public TipoMedicamento criarTipoMedicamento(final TipoMedicamento tipoMedicamento) {
		auditoriaUtil.setDadosAuditoriaCriacao(tipoMedicamento, "MOCK_MATRICULA - " + Math.random());
		return tipoMedicamentoRep.save(tipoMedicamento);
	}

	@Override
	public void deletarTipoMedicamento(final Short codigoTipoMedicamento) {
		tipoMedicamentoRep.deleteById(codigoTipoMedicamento);
	}

	@Override
	public Page<TipoMedicamento> listarTipoMedicamento(final PageRequest pageable) {
		return tipoMedicamentoRep.findAll(pageable);
	}

}
