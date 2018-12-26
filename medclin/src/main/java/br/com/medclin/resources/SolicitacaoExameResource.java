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

import br.com.medclin.facade.SolicitacaoExameFacade;
import br.com.medclin.model.SolicitacaoExame;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/solicitacao-exame")
public class SolicitacaoExameResource {

	@Autowired
	private SolicitacaoExameFacade solicitacaoExameFacade;

//	@PutMapping
//	public Exame atualizarTipoContato(@RequestBody @Valid final Exame exame) {
//		return exameFacade.atualizarExame(exame);
//	}
//
//	@GetMapping("/{page}/{size}/{nomeExame}")
//	public Page<Exame> buscarExamePorNome(@PathVariable final Integer page,
//			@PathVariable final Integer size, @PathVariable final String nomeExame) {
//		return exameFacade.buscarExamePorNome(PageRequest.of(page.intValue(), size.intValue()),
//				nomeExame);
//	}

//	@GetMapping("/{codigoSolicitacaoExame}")
//	public Exame buscarSolicitacaoExamePorCodigo(@PathVariable final Short codigoSolicitacaoExame) {
//		return solicitacaoExameFacade.buscarSolicitacaoExamePorCodigo(codigoSolicitacaoExame);
//	}
	
	@GetMapping("/{page}/{size}/{codigoPaciente}")
	public @ResponseBody Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final BigInteger codigoPaciente) {
		return solicitacaoExameFacade.listarSolicitacaoExameCodigoPaciente(PageRequest.of(page.intValue(), size.intValue()), codigoPaciente);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<SolicitacaoExame> listarSolicitacaoExame(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return solicitacaoExameFacade.listarSolicitacaoExame(PageRequest.of(page.intValue(), size.intValue()));
	}

//	@PostMapping
//	public Exame criarExame(@RequestBody @Valid final Exame exame) {
//		return exameFacade.criarExame(exame);
//	}

//	@DeleteMapping("/{codigoExame}")
//	public void deletarExame(@PathVariable final Short codigoExame) {
//		exameFacade.deletarExame(codigoExame);
//	}
}
