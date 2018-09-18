package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.TipoPlanoSaude;

public interface ITipoPlanoSaudeBusiness {

	public TipoPlanoSaude atualizarTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude);

	public Page<TipoPlanoSaude> buscarTipoPlanoSaudePorNome(final PageRequest pageable,
			final String nomeTipoPlanoSaude);

	public TipoPlanoSaude buscarTipoPlanoSaudePorCodigo(final Short codigoTipoPlanoSaude);

	public TipoPlanoSaude criarTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude);

	public void deletarTipoPlanoSaude(final Short codigoTipoPlanoSaude);

	public Page<TipoPlanoSaude> listarTipoPlanoSaude(final PageRequest pageable);

}
