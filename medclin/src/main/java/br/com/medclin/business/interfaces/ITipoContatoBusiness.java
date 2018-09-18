package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.TipoContato;

public interface ITipoContatoBusiness {

	public TipoContato atualizarTipoContato(final TipoContato tipoContato);

	public Page<TipoContato> buscarTipoContatoPorNome(final PageRequest pageable, final String nomeTipoContato);

	public TipoContato buscarTipoContatoPorCodigo(final Short codigoTipoContato);

	public TipoContato criarTipoContato(final TipoContato tipoContato);

	public void deletarTipoContato(final Short codigoTipoContato);

	public Page<TipoContato> listarTipoContato(final PageRequest pageable);

}
