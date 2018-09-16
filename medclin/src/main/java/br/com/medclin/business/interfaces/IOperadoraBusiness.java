package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Operadora;

public interface IOperadoraBusiness {

	public Operadora atualizarOperadora(final Operadora operadora);

	public Page<Operadora> buscarOperadoraPorNome(final PageRequest pageable, final String nomeOperadora);

	public Iterable<Operadora> buscarOperadoraPorCodigo(final Short codigoOperadora);

	public Iterable<Operadora> buscarOperadoraPorCodigoOficial(final Integer codigoOficial);

	public Operadora criarOperadora(final Operadora operadora);

	public void deletarOperadora(final Short codigoOperadora);

	public Page<Operadora> listarOperadora(final PageRequest pageable);

}
