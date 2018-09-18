/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IOperadoraBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.Operadora;
import br.com.medclin.repository.OperadoraRepository;

@Configuration
public class OperadoraBusiness implements IOperadoraBusiness {

	@Autowired
	private OperadoraRepository operadoraRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Operadora atualizarOperadora(final Operadora operadora) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(operadora, "MOCK_MATRICULA - " + Math.random());
		return operadoraRep.saveAndFlush(operadora);
	}

	@Override
	public Operadora buscarOperadoraPorCodigo(final Short codigoOperadora) {
		return operadoraRep.buscarOperadoraPorCodigo(codigoOperadora);
	}

	@Override
	public Page<Operadora> buscarOperadoraPorNome(final PageRequest pageable, final String nomeOperadora) {
		return operadoraRep.buscarOperadoraPorNome(nomeOperadora, pageable);
	}

	@Override
	public Operadora criarOperadora(final Operadora operadora) {
		auditoriaUtil.setDadosAuditoriaCriacao(operadora, "MOCK_MATRICULA - " + Math.random());
		return operadoraRep.save(operadora);
	}

	@Override
	public void deletarOperadora(final Short codigoOperadora) {
		operadoraRep.deleteById(codigoOperadora);
	}

	@Override
	public Page<Operadora> listarOperadora(final PageRequest pageable) {
		return operadoraRep.findAll(pageable);
	}

	@Override
	public Iterable<Operadora> buscarOperadoraPorCodigoOficial(final Integer codigoOficial) {
		return operadoraRep.buscarOperadoraPorCodigoOficial(codigoOficial);
	}

}
