/*
 * 
 */
package br.com.medclin.resources;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.SolicitacaoMedicamentoFacade;
import br.com.medclin.model.SolicitacaoMedicamento;

@RestController
@RequestMapping(value = "/medclin/solicitacao-medicamento")
public class SolicitacaoMedicamentoResource {

	@Autowired
	private SolicitacaoMedicamentoFacade solicitacaoMedicamentoFacade;
	
	@GetMapping("/{page}/{size}/{codigoPaciente}")
	public @ResponseBody Page<SolicitacaoMedicamento> listarSolicitacaoMedicamentoCodigoPaciente(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final BigInteger codigoPaciente) {
		return solicitacaoMedicamentoFacade.listarSolicitacaoMedicamentoCodigoPaciente(PageRequest.of(page.intValue(), size.intValue()), codigoPaciente);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<SolicitacaoMedicamento> listarSolicitacaoMedicamento(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return solicitacaoMedicamentoFacade.listarSolicitacaoMedicamento(PageRequest.of(page.intValue(), size.intValue()));
	}
}
