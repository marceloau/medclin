package br.com.medclin.business;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEnderecoPessoaBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;
import br.com.medclin.repository.EnderecoPessoaRepository;

@Configuration
public class EnderecoPessoaBusiness implements IEnderecoPessoaBusiness {

	@Autowired
	private EnderecoPessoaRepository contatoPessoaRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public void criarListaEnderecoPessoa(final List<EnderecoPessoa> listaEnderecoPessoa,
			final BigInteger codigoPessoa) {
		Integer nexId = 1;
		EnderecoPessoaPK enderecoPessoaPK = null;
		if (AssertUtil.isNotEmptyList(listaEnderecoPessoa)) {
			for (EnderecoPessoa contato : listaEnderecoPessoa) {
				enderecoPessoaPK = new EnderecoPessoaPK();
				enderecoPessoaPK.setCodigoEnderecoPessoa(nexId);
				enderecoPessoaPK.setCodigoPessoa(codigoPessoa);
				contato.setEnderecoPessoaPK(enderecoPessoaPK);
				nexId = nexId + 1;
				auditoriaUtil.setDadosAuditoriaCriacao(contato, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.save(contato);
			}
		}
	}

	@Override
	public void atualizarListaEnderecoPessoa(List<EnderecoPessoa> listaEnderecoPessoa) {
		if (AssertUtil.isNotEmptyList(listaEnderecoPessoa)) {
			for (EnderecoPessoa endereco : listaEnderecoPessoa) {
				auditoriaUtil.setDadosAuditoriaAtualizacao(endereco, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.saveAndFlush(endereco);
			}
		}
	}

}
