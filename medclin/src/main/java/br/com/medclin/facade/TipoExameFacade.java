package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ITipoExameBusiness;
import br.com.medclin.model.TipoExame;

@Configuration
public class TipoExameFacade {

	@Autowired
	private ITipoExameBusiness tipoExameBusiness;

	public TipoExame atualizarTipoExame(final TipoExame tipoExame) {
		return tipoExameBusiness.atualizarTipoExame(tipoExame);
	}

	public Page<TipoExame> buscarTipoExamePorNome(final PageRequest pageable, final String nomeTipoExame) {
		return tipoExameBusiness.buscarTipoExamePorNome(pageable, nomeTipoExame);
	}

	public TipoExame buscarTipoExamePorCodigo(final Short codigoTipoExame) {
		return tipoExameBusiness.buscarTipoExamePorCodigo(codigoTipoExame);
	}

	public TipoExame criarTipoExame(final TipoExame tipoExame) {
		return tipoExameBusiness.criarTipoExame(tipoExame);
	}

	public void deletarTipoExame(final Short codigoTipoExame) {
		tipoExameBusiness.deletarTipoExame(codigoTipoExame);
	}

	public Page<TipoExame> listarTipoExame(final PageRequest pageable) {
		return tipoExameBusiness.listarTipoExame(pageable);
	}

}
