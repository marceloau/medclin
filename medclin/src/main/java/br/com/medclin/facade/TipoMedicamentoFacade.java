package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoMedicamentoBusiness;
import br.com.medclin.model.TipoMedicamento;

@Configuration
public class TipoMedicamentoFacade {

	@Autowired
	private ITipoMedicamentoBusiness tipoMedicamentoBusiness;

	public TipoMedicamento atualizarTipoMedicamento(final TipoMedicamento tipoMedicamento) {
		return tipoMedicamentoBusiness.atualizarTipoMedicamento(tipoMedicamento);
	}

	public Page<TipoMedicamento> buscarTipoMedicamentoPorNome(final PageRequest pageable,
			final String nomeTipoMedicamento) {
		return tipoMedicamentoBusiness.buscarTipoMedicamentoPorNome(pageable, nomeTipoMedicamento);
	}

	public TipoMedicamento buscarTipoMedicamentoPorCodigo(final Short codigoTipoMedicamento) {
		return tipoMedicamentoBusiness.buscarTipoMedicamentoPorCodigo(codigoTipoMedicamento);
	}

	public TipoMedicamento criarTipoMedicamento(final TipoMedicamento tipoMedicamento) {
		return tipoMedicamentoBusiness.criarTipoMedicamento(tipoMedicamento);
	}

	public void deletarTipoMedicamento(final Short codigoTipoMedicamento) {
		tipoMedicamentoBusiness.deletarTipoMedicamento(codigoTipoMedicamento);
	}

	public Page<TipoMedicamento> listarTipoMedicamento(final PageRequest pageable) {
		return tipoMedicamentoBusiness.listarTipoMedicamento(pageable);
	}

}
