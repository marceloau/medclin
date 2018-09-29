package br.com.medclin.business;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IContatoPessoaBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.repository.ContatoPessoaRepository;

@Configuration
public class ContatoPessoaBusiness implements IContatoPessoaBusiness {

	@Autowired
	private ContatoPessoaRepository contatoPessoaRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public void criarListaContatoPessoa(final List<ContatoPessoa> listaContatoPessoa, final BigInteger codigoPessoa) {
		Integer nexId = 1;
		ContatoPessoaPK contatoPessoaPK = null;
		if (AssertUtil.isNotEmptyList(listaContatoPessoa)) {
			for (ContatoPessoa contato : listaContatoPessoa) {
				contatoPessoaPK = new ContatoPessoaPK();
				contatoPessoaPK.setCodigoContatoPessoa(nexId);
				contatoPessoaPK.setCodigoPessoa(codigoPessoa);
				contato.setContatoPessoaPK(contatoPessoaPK);
				nexId = nexId + 1;
				auditoriaUtil.setDadosAuditoriaCriacao(contato, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.save(contato);
			}
		}
	}

	@Override
	public void atualizarListaContatoPessoa(List<ContatoPessoa> listaContatoPessoa) {
		if (AssertUtil.isNotEmptyList(listaContatoPessoa)) {
			for (ContatoPessoa contato : listaContatoPessoa) {
				auditoriaUtil.setDadosAuditoriaAtualizacao(contato, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.saveAndFlush(contato);
			}
		}
	}

}
