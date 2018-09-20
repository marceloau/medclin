package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IOperadoraBusiness;
import br.com.medclin.model.Operadora;

@Configuration
public class OperadoraFacade {

	@Autowired
	private IOperadoraBusiness operadoraBusiness;

	public Operadora atualizarOperadora(final Operadora operadora) {
		return operadoraBusiness.atualizarOperadora(operadora);
	}

	public Page<Operadora> buscarOperadoraPorNome(final PageRequest pageable, final String nomeOperadora) {
		return operadoraBusiness.buscarOperadoraPorNome(pageable, nomeOperadora);
	}

	public Operadora buscarOperadoraPorCodigo(final Short codigoOperadora) {
		return operadoraBusiness.buscarOperadoraPorCodigo(codigoOperadora);
	}

	public Operadora buscarOperadoraPorCodigoOficial(final Integer codigoOficial) {
		return operadoraBusiness.buscarOperadoraPorCodigoOficial(codigoOficial);
	}

	public Operadora criarOperadora(final Operadora operadora) {
		return operadoraBusiness.criarOperadora(operadora);
	}

	public void deletarOperadora(final Short codigoOperadora) {
		operadoraBusiness.deletarOperadora(codigoOperadora);
	}

	public Page<Operadora> listarOperadora(final PageRequest pageable) {
		return operadoraBusiness.listarOperadora(pageable);
	}

}
