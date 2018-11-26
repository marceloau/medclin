/*
 * 
 */
package br.com.medclin.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.ExameFacade;
import br.com.medclin.model.Exame;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/exame")
public class ExameResource {

	@Autowired
	private ExameFacade exameFacade;

	@PutMapping
	public Exame atualizarTipoContato(@RequestBody @Valid final Exame exame) {
		return exameFacade.atualizarExame(exame);
	}

	@GetMapping("/{page}/{size}/{nomeExame}")
	public Page<Exame> buscarExamePorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeExame) {
		return exameFacade.buscarExamePorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeExame);
	}

	@GetMapping("/{codigoExame}")
	public Exame buscarExamePorCodigo(@PathVariable final Short codigoExame) {
		return exameFacade.buscarExamePorCodigo(codigoExame);
	}

	@PostMapping
	public Exame criarExame(@RequestBody @Valid final Exame exame) {
		return exameFacade.criarExame(exame);
	}

	@DeleteMapping("/{codigoExame}")
	public void deletarExame(@PathVariable final Short codigoExame) {
		exameFacade.deletarExame(codigoExame);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Exame> listarExame(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return exameFacade.listarExame(PageRequest.of(page.intValue(), size.intValue()));
	}
}
