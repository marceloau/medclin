package br.com.medclin.business.interfaces;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public interface IImpressaoBusiness {

	//public ByteArrayOutputStream medicamento(final String listaMedicamento, final BigInteger codigoConsulta);
	
	public String medicamento(final String listaMedicamento, final BigInteger codigoConsulta);
	
}
