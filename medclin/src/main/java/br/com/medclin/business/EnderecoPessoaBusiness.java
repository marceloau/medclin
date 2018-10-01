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
			for (EnderecoPessoa endereco : listaEnderecoPessoa) {
				enderecoPessoaPK = new EnderecoPessoaPK();
				enderecoPessoaPK.setCodigoEnderecoPessoa(nexId);
				enderecoPessoaPK.setCodigoPessoa(codigoPessoa);
				endereco.setEnderecoPessoaPK(enderecoPessoaPK);
				nexId = nexId + 1;
				auditoriaUtil.setDadosAuditoriaCriacao(endereco, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.save(endereco);
			}
		}
	}

	@Override
	public void atualizarListaEnderecoPessoa(final List<EnderecoPessoa> listaEnderecoPessoa, final BigInteger codigoPessoa) {
		if (AssertUtil.isNotEmptyList(listaEnderecoPessoa)) {
			Integer nexId = 1;
			EnderecoPessoaPK enderecoPessoaPK = null;
			for (EnderecoPessoa endereco : listaEnderecoPessoa) {
				if(endereco.getEnderecoPessoaPK() == null) {
					enderecoPessoaPK = new EnderecoPessoaPK();
					enderecoPessoaPK.setCodigoEnderecoPessoa(nexId);
					enderecoPessoaPK.setCodigoPessoa(codigoPessoa);
					endereco.setEnderecoPessoaPK(enderecoPessoaPK);
					nexId = nexId + 1;
				}
				auditoriaUtil.setDadosAuditoriaAtualizacao(endereco, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.saveAndFlush(endereco);
			}
		}
	}

}
