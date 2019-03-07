/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IContatoPessoaBusiness;
import br.com.medclin.business.interfaces.IEnderecoPessoaBusiness;
import br.com.medclin.business.interfaces.IPacienteBusiness;
import br.com.medclin.business.interfaces.IPlanoSaudePacienteBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.dao.PacienteDAO;
import br.com.medclin.model.Paciente;
import br.com.medclin.repository.PacienteRepository;

@Configuration
public class PacienteBusiness implements IPacienteBusiness {

	@Autowired
	private PacienteRepository pacienteRep;

	@Autowired
	private PacienteDAO pacienteDao;

	@Autowired
	private IContatoPessoaBusiness contatoPessoaBusiness;

	@Autowired
	private IEnderecoPessoaBusiness enderecoPessoaBusiness;

	@Autowired
	private IPlanoSaudePacienteBusiness planoSaudePacienteBusiness;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Paciente atualizarPaciente(final Paciente paciente) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(paciente, "MOCK_MATRICULA - " + Math.random());
		final Paciente pacienteRetorno = pacienteRep.saveAndFlush(paciente);
		contatoPessoaBusiness.atualizarListaContatoPessoa(paciente.getContatos(), paciente.getCodigoPessoa());
		enderecoPessoaBusiness.atualizarListaEnderecoPessoa(paciente.getEnderecos(), paciente.getCodigoPessoa());
		planoSaudePacienteBusiness.atualizarListaPlanoSaudePaciente(paciente.getListaPlanoSaudePaciente(), paciente.getCodigoPessoa());
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
		return cloneUtil.cloneListaPaciente(pacienteDao.buscarPaciente(pageable, nomePaciente, nomeMae, numeroRg,
				numeroCpf, numeroCartaoSUS, codigoTipoPlano, textoContato));
	}

	@Override
	public Paciente criarPaciente(final Paciente paciente) {
		Paciente pacienteRetorno = null;

		auditoriaUtil.setDadosAuditoriaCriacao(paciente, "MOCK_MATRICULA - " + Math.random());
		pacienteRetorno = pacienteRep.save(paciente);
		contatoPessoaBusiness.criarListaContatoPessoa(paciente.getContatos(), paciente.getCodigoPessoa());
		enderecoPessoaBusiness.criarListaEnderecoPessoa(paciente.getEnderecos(), paciente.getCodigoPessoa());
		planoSaudePacienteBusiness.criarListaPlanoSaudePaciente(paciente.getListaPlanoSaudePaciente(),
				paciente.getCodigoPessoa());
		return cloneUtil.clonePaciente(pacienteRetorno);
	}

	@Override
	public void deletarPaciente(final BigInteger codigoPaciente) {
		pacienteRep.deleteById(codigoPaciente);
	}

	@Override
	public Page<Paciente> listarPaciente(final PageRequest pageable) {
		return cloneUtil.cloneListaPaciente(pacienteRep.findAll(pageable));
	}
	
	@Override
	public BigInteger totalPacientes() {
		return pacienteRep.totalPacientes();
	}
}
