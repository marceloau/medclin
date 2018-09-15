/*
 * 
 */
package br.com.medclin.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IParametroConfiguracaoBusiness;
import br.com.medclin.model.ParametroConfiguracao;
import br.com.medclin.repository.ParametroConfiguracaoRepository;

@Configuration
public class ParametroConfiguracaoBusiness implements IParametroConfiguracaoBusiness {

	/** The parametro rep. */
	@Autowired
	private ParametroConfiguracaoRepository parametroRep;

	@Override
	public ParametroConfiguracao atualizaParametro(final ParametroConfiguracao parametroConfiguracao) {
		parametroConfiguracao.setDataUltimaAlteracao(new Date());
		return parametroRep.saveAndFlush(parametroConfiguracao);
	}

	@Override
	public Iterable<ParametroConfiguracao> buscaParametroConfiguracaoPorNome(final Integer page, final Integer size,
			final String nomeParametro) {
		return parametroRep.buscarParametroPorNome(nomeParametro, PageRequest.of(page.intValue(), size.intValue()));
	}

	@Override
	public ParametroConfiguracao criarParametro(final ParametroConfiguracao parametroConfiguracao) {
		parametroConfiguracao.setDataUltimaAlteracao(new Date());
		return parametroRep.save(parametroConfiguracao);
	}

	@Override
	public ParametroConfiguracao deletaParametro(final ParametroConfiguracao parametroConfiguracao) {
		parametroRep.delete(parametroConfiguracao);
		return parametroConfiguracao;
	}

	@Override
	public Iterable<ParametroConfiguracao> listarParametroConfiguracao() {
		return parametroRep.findAll();
	}

}
