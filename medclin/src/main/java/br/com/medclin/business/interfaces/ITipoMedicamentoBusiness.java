package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.TipoMedicamento;

public interface ITipoMedicamentoBusiness {

	public TipoMedicamento atualizarTipoMedicamento(final TipoMedicamento tipoMedicamento);

	public Page<TipoMedicamento> buscarTipoMedicamentoPorNome(final PageRequest pageable,
			final String nomeTipoMedicamento);

	public TipoMedicamento buscarTipoMedicamentoPorCodigo(final Short codigoTipoMedicamento);

	public TipoMedicamento criarTipoMedicamento(final TipoMedicamento tipoMedicamento);

	public void deletarTipoMedicamento(final Short codigoTipoMedicamento);

	public Page<TipoMedicamento> listarTipoMedicamento(final PageRequest pageable);

}
