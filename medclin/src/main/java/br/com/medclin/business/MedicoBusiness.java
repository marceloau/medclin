/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IMedicoBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;
import br.com.medclin.model.Medico;
import br.com.medclin.repository.ContatoPessoaRepository;
import br.com.medclin.repository.EnderecoPessoaRepository;
import br.com.medclin.repository.MedicoRepository;

@Configuration
public class MedicoBusiness implements IMedicoBusiness {

	@Autowired
	private MedicoRepository medicoRep;

	@Autowired
	private ContatoPessoaRepository contatoPessoaRep;

	@Autowired
	private EnderecoPessoaRepository enderecoPessoaRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Medico atualizarMedico(final Medico medico) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(medico, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneMedico(medicoRep.saveAndFlush(medico));
	}

	@Override
	public Medico buscarMedicoPorCodigo(final Long codigoMedico) {
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

		setCodigoContatoPessoa(medicoRetorno);
		setCodigoEnderecoPessoa(medicoRetorno);
		return medicoRetorno;
	}

	@Override
	public void deletarMedico(final Long codigoMedico) {
		medicoRep.deleteById(codigoMedico);
	}

	@Override
	public Page<Medico> listarMedico(final PageRequest pageable) {
		return cloneUtil.cloneListaMedico(medicoRep.findAll(pageable));
	}

	private void setCodigoContatoPessoa(final Medico medico) {
		Integer nexId = 1;
		ContatoPessoaPK contatoPessoaPK = null;
		if (AssertUtil.isNotNull(medico) && AssertUtil.isNotEmptyList(medico.getContatos())) {
			for (ContatoPessoa contato : medico.getContatos()) {
				contatoPessoaPK = new ContatoPessoaPK();
				contatoPessoaPK.setCodigoContatoPessoa(nexId);
				contatoPessoaPK.setCodigoPessoa(medico.getCodigoPessoa());
				contato.setContatoPessoaPK(contatoPessoaPK);
				nexId = nexId + 1;
			}
		}
		contatoPessoaRep.saveAll(medico.getContatos());
	}

	private void setCodigoEnderecoPessoa(final Medico medico) {
		Integer nexId = 1;
		EnderecoPessoaPK enderecoPessoaPK = null;
		if (AssertUtil.isNotNull(medico) && AssertUtil.isNotEmptyList(medico.getEnderecos())) {
			for (EnderecoPessoa endereco : medico.getEnderecos()) {
				enderecoPessoaPK = new EnderecoPessoaPK();
				enderecoPessoaPK.setCodigoEnderecoPessoa(nexId);
				enderecoPessoaPK.setCodigoPessoa(medico.getCodigoPessoa());
				endereco.setEnderecoPessoaPK(enderecoPessoaPK);
				nexId = nexId + 1;
			}
		}
		enderecoPessoaRep.saveAll(medico.getEnderecos());
	}
}
