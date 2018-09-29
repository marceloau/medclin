package br.com.medclin.business.interfaces;

import java.math.BigInteger;
import java.util.List;

import br.com.medclin.model.AgendaMedico;

public interface IAgendaMedicoBusiness {

	public void criarListaAgendaMedico(final List<AgendaMedico> listaAgendaMedico, final BigInteger codigoPessoa);

	public void atualizarListaAgendaMedico(final List<AgendaMedico> listaAgendaMedico);

}
