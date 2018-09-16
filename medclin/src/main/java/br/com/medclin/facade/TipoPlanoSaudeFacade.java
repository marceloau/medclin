package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoPlanoSaudeBusiness;
import br.com.medclin.model.TipoPlanoSaude;

@Configuration
public class TipoPlanoSaudeFacade {

	@Autowired
	private ITipoPlanoSaudeBusiness tipoPlanoSaudeBusiness;

	public TipoPlanoSaude atualizarTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude) {
		return tipoPlanoSaudeBusiness.atualizarTipoPlanoSaude(tipoPlanoSaude);
	}

	public Page<TipoPlanoSaude> buscarTipoPlanoSaudePorNome(final PageRequest pageable,
			final String nomeTipoPlanoSaude) {
		return tipoPlanoSaudeBusiness.buscarTipoPlanoSaudePorNome(pageable, nomeTipoPlanoSaude);
	}

	public Iterable<TipoPlanoSaude> buscarTipoPlanoSaudePorCodigo(final Short codigoTipoPlanoSaude) {
		return tipoPlanoSaudeBusiness.buscarTipoPlanoSaudePorCodigo(codigoTipoPlanoSaude);
	}

	public TipoPlanoSaude criarTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude) {
		return tipoPlanoSaudeBusiness.criarTipoPlanoSaude(tipoPlanoSaude);
	}

	public void deletarTipoPlanoSaude(final Short codigoTipoPlanoSaude) {
		tipoPlanoSaudeBusiness.deletarTipoPlanoSaude(codigoTipoPlanoSaude);
	}

	public Page<TipoPlanoSaude> listarTipoPlanoSaude(final PageRequest pageable) {
		return tipoPlanoSaudeBusiness.listarTipoPlanoSaude(pageable);
	}

}
