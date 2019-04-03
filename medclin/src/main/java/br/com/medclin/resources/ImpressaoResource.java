package br.com.medclin.resources;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.ImpressaoFacade;
import br.com.medclin.model.ebo.ImpressaoResponse;

@RestController
@RequestMapping(value = "/medclin/impressao")
public class ImpressaoResource {
	@Autowired
	private ImpressaoFacade impressaoFacade;

//	@GetMapping("/medicamento")
//	public ResponseEntity<byte[]> medicamento(@RequestParam("listaMedicamento") String listaMedicamento,
//			@RequestParam("codigoConsulta") BigInteger codigoConsulta) {
//		
//		final ByteArrayOutputStream retorno = impressaoFacade.medicamento(listaMedicamento, codigoConsulta);
//		
//		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Medicamento.pdf" + "\"")
//				.body(retorno.toByteArray());
//	}
	
	@GetMapping("/medicamento")
	public ImpressaoResponse medicamento(@RequestParam("listaMedicamento") String listaMedicamento,
			@RequestParam("codigoConsulta") BigInteger codigoConsulta) {
		
		//final ByteArrayOutputStream retorno = impressaoFacade.medicamento(listaMedicamento, codigoConsulta);
		
		final ImpressaoResponse retorno = new ImpressaoResponse();
		retorno.setNomeArquivo(impressaoFacade.medicamento(listaMedicamento, codigoConsulta));
		
		return retorno;
	}
	
	@GetMapping("/historico-clinico")
	public ImpressaoResponse historicoClinico(@RequestParam("codigoPaciente") BigInteger codigoPaciente) {
		
		//final ByteArrayOutputStream retorno = impressaoFacade.medicamento(listaMedicamento, codigoConsulta);
		
		final ImpressaoResponse retorno = new ImpressaoResponse();
		retorno.setNomeArquivo(impressaoFacade.historicoClinico(codigoPaciente));
		
		return retorno;
	}
}
