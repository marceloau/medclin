package br.com.medclin.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IImpressaoBusiness;

@Configuration
public class ImpressaoFacade {

	@Autowired
	private IImpressaoBusiness impressaoBusiness;

	public String medicamento(final String listaMedicamento, final BigInteger codigoConsulta) {
		return impressaoBusiness.medicamento(listaMedicamento, codigoConsulta);
	}
	
	public String historicoClinico(final BigInteger codigoPaciente) {
		return impressaoBusiness.historicoClinico(codigoPaciente);
	}
}
