/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IMedicamentoBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.Medicamento;
import br.com.medclin.repository.MedicamentoRepository;

@Configuration
public class MedicamentoBusiness implements IMedicamentoBusiness {

	@Autowired
	private MedicamentoRepository medicamentoRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Medicamento atualizarMedicamento(final Medicamento medicamento) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(medicamento, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneMedicamento(medicamentoRep.saveAndFlush(medicamento));
	}

	@Override
	public Medicamento buscarMedicamentoPorCodigo(final Short codigoMedicamento) {
		return cloneUtil.cloneMedicamento(medicamentoRep.buscarMedicamentoPorCodigo(codigoMedicamento));
	}

	@Override
	public Page<Medicamento> buscarMedicamentoPorNome(final PageRequest pageable, final String nomeMedicamento) {
		return cloneUtil.cloneListaMedicamento(medicamentoRep.buscarMedicamentoPorNome(nomeMedicamento, pageable));
	}

	@Override
	public Medicamento criarMedicamento(final Medicamento medicamento) {
		auditoriaUtil.setDadosAuditoriaCriacao(medicamento, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneMedicamento(medicamentoRep.save(medicamento));
	}

	@Override
	public void deletarMedicamento(final Short codigoMedicamento) {
		medicamentoRep.deleteById(codigoMedicamento);
	}

	@Override
	public Page<Medicamento> listarMedicamento(final PageRequest pageable) {
		return cloneUtil.cloneListaMedicamento(medicamentoRep.findAll(pageable));
	}

}
