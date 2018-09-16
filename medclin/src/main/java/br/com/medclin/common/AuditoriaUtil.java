package br.com.medclin.common;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.Especialidade;
import br.com.medclin.model.TipoContato;

@Configuration
public class AuditoriaUtil {

	public void setDadosAuditoriaCriacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setFlagAtivo("S");
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
			((Especialidade) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof TipoContato) {
			((TipoContato) entidade).setDataUltimaAlteracao(new Date());
			((TipoContato) entidade).setFlagAtivo("S");
			((TipoContato) entidade).setUsuarioUltimaAlteracao(matricula);
			((TipoContato) entidade).setDataCriacao(new Date());
		}
	}

	public void setDadosAuditoriaAtualizacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof TipoContato) {
			((TipoContato) entidade).setDataUltimaAlteracao(new Date());
			((TipoContato) entidade).setUsuarioUltimaAlteracao(matricula);
		}
	}
}
