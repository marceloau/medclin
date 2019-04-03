package br.com.medclin.model.ebo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.medclin.common.AssertUtil;
import br.com.medclin.model.Consulta;
import br.com.medclin.model.Exame;

@XmlRootElement(name = "impressao")
public class ImpressaoEBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MedicamentoImpressaoEBO medicamento;
	
	private List<Consulta> consulta;
	
	private List<Exame> exame;
	
	private DiversosEBO diversos;
	
	public ImpressaoEBO() {
	}
	
	@XmlElementWrapper(name = "Consultas")
	@XmlElement(name = "Consulta")
	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}
	
	public void addConsulta(Consulta consulta) {
		if(AssertUtil.isNotEmptyList(this.consulta)) {			
			this.consulta.add(consulta);
		} else {
			this.consulta = new ArrayList<Consulta>();
			this.consulta.add(consulta);
		}
	}
	
	@XmlElementWrapper(name = "Exames")
	@XmlElement(name = "Exame")
	public List<Exame> getExame() {
		return exame;
	}

	public void setExame(List<Exame> exame) {
		this.exame = exame;
	}
	
	public void addExame(Exame exame) {
		if(AssertUtil.isNotEmptyList(this.exame)) {			
			this.exame.add(exame);
		} else {
			this.exame = new ArrayList<Exame>();
			this.exame.add(exame);
		}
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