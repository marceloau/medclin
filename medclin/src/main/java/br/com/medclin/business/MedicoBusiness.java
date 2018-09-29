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
import br.com.medclin.business.interfaces.IEspecialidadeMedicoBusiness;
import br.com.medclin.business.interfaces.IMedicoBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.Medico;
import br.com.medclin.repository.MedicoRepository;

@Configuration
public class MedicoBusiness implements IMedicoBusiness {

	@Autowired
	private MedicoRepository medicoRep;

	@Autowired
	private IContatoPessoaBusiness contatoPessoaBusiness;

	@Autowired
	private IEnderecoPessoaBusiness enderecoPessoaBusiness;

	@Autowired
	private IEspecialidadeMedicoBusiness especialidadeMedicoBusiness;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Medico atualizarMedico(final Medico medico) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(medico, "MOCK_MATRICULA - " + Math.random());
		contatoPessoaBusiness.atualizarListaContatoPessoa(medico.getContatos());
		enderecoPessoaBusiness.atualizarListaEnderecoPessoa(medico.getEnderecos());
		especialidadeMedicoBusiness.atualizarListaEspecialidadeMedico(medico.getListaEspecialidadeMedico());
		return cloneUtil.cloneMedico(medicoRep.saveAndFlush(medico));
	}

	@Override
	public Medico buscarMedicoPorCodigo(final BigInteger codigoMedico) {
		return cloneUtil.cloneMedico(medicoRep.buscarMedicoPorCodigo(codigoMedico));
	}

	@Override
	public Page<Medico> buscarMedicoPorNome(final PageRequest pageable, final String nomeMedico) {
		return cloneUtil.cloneListaMedico(medicoRep.buscarMedicoPorNome(nomeMedico, pageable));
	}

	@Override
	public Medico criarMedico(final Medico medico) {
		Medico medicoRetorno = null;

		auditoriaUtil.setDadosAuditoriaCriacao(medico, "MOCK_MATRICULA - " + Math.random());
		medicoRetorno = medicoRep.save(medico);
		contatoPessoaBusiness.criarListaContatoPessoa(medico.getContatos(), medico.getCodigoPessoa());
		enderecoPessoaBusiness.criarListaEnderecoPessoa(medico.getEnderecos(), medico.getCodigoPessoa());
		especialidadeMedicoBusiness.criarListaEspecialidadeMedico(medico.getListaEspecialidadeMedico(),
				medico.getCodigoPessoa());
		return medicoRetorno;
	}

	@Override
	public void deletarMedico(final BigInteger codigoMedico) {
		medicoRep.deleteById(codigoMedico);
	}

	@Override
	public Page<Medico> listarMedico(final PageRequest pageable) {
		return cloneUtil.cloneListaMedico(medicoRep.findAll(pageable));
	}

}
