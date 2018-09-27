/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;

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
		final Paciente pacienteRetorno = pacienteRep.saveAndFlush(paciente);
		setCodigoContatoPessoa(paciente);
		setCodigoEnderecoPessoa(paciente);
		return cloneUtil.clonePaciente(pacienteRetorno);
	}

	@Override
	public Paciente buscarPacientePorCodigo(final BigInteger codigoPaciente) {
		return cloneUtil.clonePaciente(pacienteRep.buscarPacientePorCodigo(codigoPaciente));
	}

	@Override
	public Page<Paciente> buscarPaciente(final PageRequest pageable, final String nomePaciente, final String nomeMae,
			final String numeroRg, final String numeroCpf, final String numeroCartaoSUS, final Short codigoTipoPlano,
			final String textoContato) {
		return cloneUtil.cloneListaPaciente(pacienteRep.buscarPaciente(pageable, nomePaciente, nomeMae, numeroRg,
				numeroCpf, numeroCartaoSUS, codigoTipoPlano, textoContato));
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
	public void deletarPaciente(final BigInteger codigoPaciente) {
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
				nexId = nexId + 1;
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
				nexId = nexId + 1;
			}
		}
		enderecoPessoaRep.saveAll(paciente.getEnderecos());
	}
}
