package br.com.medclin.model.ebo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import br.com.medclin.model.Consulta;

@XmlRootElement(name = "impressao")
@XStreamAlias("impressao")
public class ImpressaoEBO implements Serializable {

	private static final long serialVersionUID = -1019666536682955167L;
	
	private MedicamentoImpressaoEBO medicamento;
	
	private Consulta consulta;
	
	private DiversosEBO diversos;
	
	public ImpressaoEBO() {
	}
	
	@XmlElement(name = "Consulta")
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@XmlElement(name = "Medicamentos")
	public MedicamentoImpressaoEBO getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(MedicamentoImpressaoEBO medicamento) {
		this.medicamento = medicamento;
	}

 	@XmlElement(name="Diversos")
	public DiversosEBO getDiversos() {
		return diversos;
	}
	
	public void setDiversos(final DiversosEBO diversos) {
		this.diversos = diversos;
	}
	
	public ImpressaoEBO(final MedicamentoImpressaoEBO medicamento, final DiversosEBO diversos) {
		super();
		this.medicamento = medicamento;
		this.diversos = diversos;
	}
}