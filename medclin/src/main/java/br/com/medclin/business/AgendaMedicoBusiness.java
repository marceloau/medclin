package br.com.medclin.business;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IAgendaMedicoBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.AgendaMedico;
import br.com.medclin.model.AgendaMedicoPK;
import br.com.medclin.repository.AgendaMedicoRepository;

@Configuration
public class AgendaMedicoBusiness implements IAgendaMedicoBusiness {

	@Autowired
	private AgendaMedicoRepository agendaMedicoRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public void criarListaAgendaMedico(final List<AgendaMedico> listaAgendaMedico, final BigInteger codigoPessoa) {
		Integer nexId = 1;
		AgendaMedicoPK contatoPessoaPK = null;
		if (AssertUtil.isNotEmptyList(listaAgendaMedico)) {
			for (AgendaMedico contato : listaAgendaMedico) {
				contatoPessoaPK = new AgendaMedicoPK();
				contatoPessoaPK.setCodigoAgendaMedico(nexId.shortValue());
				contatoPessoaPK.setCodigoPessoa(codigoPessoa);
				contato.setAgendaMedicoPK(contatoPessoaPK);
				nexId = nexId + 1;
				auditoriaUtil.setDadosAuditoriaCriacao(contato, "MOCK_MATRICULA - " + Math.random());
				agendaMedicoRep.save(contato);
			}
		}
	}

	@Override
	public void atualizarListaAgendaMedico(List<AgendaMedico> listaAgendaMedico) {
		if (AssertUtil.isNotEmptyList(listaAgendaMedico)) {
			for (AgendaMedico contato : listaAgendaMedico) {
				auditoriaUtil.setDadosAuditoriaAtualizacao(contato, "MOCK_MATRICULA - " + Math.random());
				agendaMedicoRep.saveAndFlush(contato);
			}
		}
	}

}
