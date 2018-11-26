/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IExameBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.Exame;
import br.com.medclin.repository.ExameRepository;

@Configuration
public class ExameBusiness implements IExameBusiness {

	@Autowired
	private ExameRepository exameRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Exame atualizarExame(final Exame exame) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(exame, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneExame(exameRep.saveAndFlush(exame));
	}

	@Override
	public Exame buscarExamePorCodigo(final Short codigoExame) {
		return cloneUtil.cloneExame(exameRep.buscarExamePorCodigo(codigoExame));
	}

	@Override
	public Page<Exame> buscarExamePorNome(final PageRequest pageable, final String nomeExame) {
		return cloneUtil.cloneListaExame(exameRep.buscarExamePorNome(nomeExame, pageable));
	}

	@Override
	public Exame criarExame(final Exame exame) {
		auditoriaUtil.setDadosAuditoriaCriacao(exame, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneExame(exameRep.save(exame));
	}

	@Override
	public void deletarExame(final Short codigoExame) {
		exameRep.deleteById(codigoExame);
	}

	@Override
	public Page<Exame> listarExame(final PageRequest pageable) {
		return cloneUtil.cloneListaExame(exameRep.findAll(pageable));
	}

}
