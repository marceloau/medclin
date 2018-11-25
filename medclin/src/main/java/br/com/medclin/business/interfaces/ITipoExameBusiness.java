package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.TipoExame;

public interface ITipoExameBusiness {

	public TipoExame atualizarTipoExame(final TipoExame tipoExame);

	public Page<TipoExame> buscarTipoExamePorNome(final PageRequest pageable, final String nomeTipoExame);

	public TipoExame buscarTipoExamePorCodigo(final Short codigoTipoExame);

	public TipoExame criarTipoExame(final TipoExame tipoExame);

	public void deletarTipoExame(final Short codigoTipoExame);

	public Page<TipoExame> listarTipoExame(final PageRequest pageable);

}
