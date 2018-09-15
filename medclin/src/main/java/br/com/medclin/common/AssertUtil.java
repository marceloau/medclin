package br.com.medclin.common;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.Especialidade;

@Configuration
public class AssertUtil {

	public void setDadosAuditoria(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setFlagAtivo("S");
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
			((Especialidade) entidade).setDataCriacao(new Date());
		}
	}
}
