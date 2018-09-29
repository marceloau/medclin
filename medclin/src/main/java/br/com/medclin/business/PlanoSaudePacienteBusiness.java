package br.com.medclin.business;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IPlanoSaudePacienteBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.PlanoSaudePaciente;
import br.com.medclin.model.PlanoSaudePacientePK;
import br.com.medclin.repository.PlanoSaudePacienteRepository;

@Configuration
public class PlanoSaudePacienteBusiness implements IPlanoSaudePacienteBusiness {

	@Autowired
	private PlanoSaudePacienteRepository contatoPessoaRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public void criarListaPlanoSaudePaciente(final List<PlanoSaudePaciente> listaPlanoSaudePaciente,
			final BigInteger codigoPessoa) {
		Integer nexId = 1;
		PlanoSaudePacientePK planoSaudePacientePK = null;
		if (AssertUtil.isNotEmptyList(listaPlanoSaudePaciente)) {
			for (PlanoSaudePaciente contato : listaPlanoSaudePaciente) {
				planoSaudePacientePK = new PlanoSaudePacientePK();
				planoSaudePacientePK.setCodigoPlanoSaudePaciente(Long.valueOf(nexId));
				planoSaudePacientePK.setCodigoPessoa(codigoPessoa);
				contato.setPlanoSaudePacientePK(planoSaudePacientePK);
				nexId = nexId + 1;
				auditoriaUtil.setDadosAuditoriaCriacao(contato, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.save(contato);
			}
		}
	}

	@Override
	public void atualizarListaPlanoSaudePaciente(List<PlanoSaudePaciente> listaPlanoSaudePaciente) {
		if (AssertUtil.isNotEmptyList(listaPlanoSaudePaciente)) {
			for (PlanoSaudePaciente planoSaude : listaPlanoSaudePaciente) {
				auditoriaUtil.setDadosAuditoriaAtualizacao(planoSaude, "MOCK_MATRICULA - " + Math.random());
				contatoPessoaRep.saveAndFlush(planoSaude);
			}
		}
	}

}
