package br.com.medclin.business;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEspecialidadeMedicoBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.EspecialidadeMedico;
import br.com.medclin.model.EspecialidadeMedicoPK;
import br.com.medclin.repository.EspecialidadeMedicoRepository;

@Configuration
public class EspecialidadeMedicoBusiness implements IEspecialidadeMedicoBusiness {

	@Autowired
	private EspecialidadeMedicoRepository especialidadeMedicoRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public void criarListaEspecialidadeMedico(final List<EspecialidadeMedico> listaEspecialidadeMedico,
			final BigInteger codigoPessoa) {
		Integer nexId = 1;
		EspecialidadeMedicoPK contatoPessoaPK = null;
		if (AssertUtil.isNotEmptyList(listaEspecialidadeMedico)) {
			for (EspecialidadeMedico contato : listaEspecialidadeMedico) {
				contatoPessoaPK = new EspecialidadeMedicoPK();
				contatoPessoaPK.setCodigoEspecialidadeMedico(nexId.shortValue());
				contatoPessoaPK.setCodigoPessoa(codigoPessoa);
				contato.setEspecialidadeMedicoPK(contatoPessoaPK);
				nexId = nexId + 1;
				auditoriaUtil.setDadosAuditoriaCriacao(contato, "MOCK_MATRICULA - " + Math.random());
				especialidadeMedicoRep.save(contato);
			}
		}
	}

	@Override
	public void atualizarListaEspecialidadeMedico(List<EspecialidadeMedico> listaEspecialidadeMedico) {
		if (AssertUtil.isNotEmptyList(listaEspecialidadeMedico)) {
			for (EspecialidadeMedico contato : listaEspecialidadeMedico) {
				auditoriaUtil.setDadosAuditoriaAtualizacao(contato, "MOCK_MATRICULA - " + Math.random());
				especialidadeMedicoRep.saveAndFlush(contato);
			}
		}
	}

}
