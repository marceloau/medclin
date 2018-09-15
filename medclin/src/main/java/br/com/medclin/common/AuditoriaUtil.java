package br.com.medclin.common;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.Especialidade;

@Configuration
public class AuditoriaUtil {

	public void setDadosAuditoriaCriacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setFlagAtivo("S");
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
			((Especialidade) entidade).setDataCriacao(new Date());
		}
	}
	
	public void setDadosAuditoriaAtualizacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
		}
	}
}
