package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IUsoMedicamentoBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.UsoMedicamento;
import br.com.medclin.repository.UsoMedicamentoRepository;

@Configuration
public class UsoMedicamentoBusiness implements IUsoMedicamentoBusiness {

	@Autowired
	private UsoMedicamentoRepository usoMedicamentoRep;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Iterable<UsoMedicamento> listarUsoMedicamento() {
		return usoMedicamentoRep.findAll();
	}

	@Override
	public UsoMedicamento buscarUsoMedicamentoPorCodigo(final Integer codigoUsoMedicamento) {
		return cloneUtil.cloneUsoMedicamento(usoMedicamentoRep.getOne(codigoUsoMedicamento));
	}

}
