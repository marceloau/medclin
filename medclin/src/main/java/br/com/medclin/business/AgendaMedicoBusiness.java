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
	public void atualizarListaAgendaMedico(List<AgendaMedico> listaAgendaMedico, final BigInteger codigoPessoa) {
		if (AssertUtil.isNotEmptyList(listaAgendaMedico)) {
			Integer nexId = 1;
			AgendaMedicoPK agendaMedicoPK = null;
			for (AgendaMedico agendaMedico : listaAgendaMedico) {
				if (agendaMedico.getAgendaMedicoPK() == null) {
					agendaMedicoPK = new AgendaMedicoPK();
					agendaMedicoPK.setCodigoAgendaMedico(nexId.shortValue());
					agendaMedicoPK.setCodigoPessoa(codigoPessoa);
					agendaMedico.setAgendaMedicoPK(agendaMedicoPK);
					nexId = nexId + 1;
				}
				auditoriaUtil.setDadosAuditoriaAtualizacao(agendaMedico, "MOCK_MATRICULA - " + Math.random());
				agendaMedicoRep.saveAndFlush(agendaMedico);
			}
		}
	}

}
