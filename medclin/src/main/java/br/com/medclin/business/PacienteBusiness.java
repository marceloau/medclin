/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IPacienteBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;
import br.com.medclin.model.Paciente;
import br.com.medclin.repository.ContatoPessoaRepository;
import br.com.medclin.repository.EnderecoPessoaRepository;
import br.com.medclin.repository.PacienteRepository;

@Configuration
public class PacienteBusiness implements IPacienteBusiness {

	@Autowired
	private PacienteRepository pacienteRep;

	@Autowired
	private ContatoPessoaRepository contatoPessoaRep;

	@Autowired
	private EnderecoPessoaRepository enderecoPessoaRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Paciente atualizarPaciente(final Paciente paciente) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(paciente, "MOCK_MATRICULA - " + Math.random());
		
		return cloneUtil.clonePaciente(pacienteRep.saveAndFlush(paciente));
	}

	@Override
	public Paciente buscarPacientePorCodigo(final Long codigoPaciente) {
		return cloneUtil.clonePaciente(pacienteRep.buscarPacientePorCodigo(codigoPaciente));
	}

	@Override
	public Page<Paciente> buscarPacientePorNome(final PageRequest pageable, final String nomePaciente) {
		return cloneUtil.cloneListaPaciente(pacienteRep.buscarPacientePorNome(nomePaciente, pageable));
	}

	@Override
	public Paciente criarPaciente(final Paciente paciente) {
		Paciente pacienteRetorno = null;

		auditoriaUtil.setDadosAuditoriaCriacao(paciente, "MOCK_MATRICULA - " + Math.random());
		pacienteRetorno = pacienteRep.save(paciente);

		setCodigoContatoPessoa(pacienteRetorno);
		setCodigoEnderecoPessoa(pacienteRetorno);
		return pacienteRetorno;
	}

	@Override
	public void deletarPaciente(final Long codigoPaciente) {
		pacienteRep.deleteById(codigoPaciente);
	}

	@Override
	public Page<Paciente> listarPaciente(final PageRequest pageable) {
		return cloneUtil.cloneListaPaciente(pacienteRep.findAll(pageable));
	}

	private void setCodigoContatoPessoa(final Paciente paciente) {
		Integer nexId = 1;
		ContatoPessoaPK contatoPessoaPK = null;
		if (AssertUtil.isNotNull(paciente) && AssertUtil.isNotEmptyList(paciente.getContatos())) {
			for (ContatoPessoa contato : paciente.getContatos()) {
				contatoPessoaPK = new ContatoPessoaPK();
				contatoPessoaPK.setCodigoContatoPessoa(nexId);
				contatoPessoaPK.setCodigoPessoa(paciente.getCodigoPessoa());
				contato.setContatoPessoaPK(contatoPessoaPK);
				nexId += nexId;
			}
		}
		contatoPessoaRep.saveAll(paciente.getContatos());
	}

	private void setCodigoEnderecoPessoa(final Paciente paciente) {
		Integer nexId = 1;
		EnderecoPessoaPK enderecoPessoaPK = null;
		if (AssertUtil.isNotNull(paciente) && AssertUtil.isNotEmptyList(paciente.getEnderecos())) {
			for (EnderecoPessoa endereco : paciente.getEnderecos()) {
				enderecoPessoaPK = new EnderecoPessoaPK();
				enderecoPessoaPK.setCodigoEnderecoPessoa(nexId);
				enderecoPessoaPK.setCodigoPessoa(paciente.getCodigoPessoa());
				endereco.setEnderecoPessoaPK(enderecoPessoaPK);
				nexId += nexId;
			}
		}
		enderecoPessoaRep.saveAll(paciente.getEnderecos());
	}
}
