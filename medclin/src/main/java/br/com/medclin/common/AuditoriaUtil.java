package br.com.medclin.common;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.Especialidade;
import br.com.medclin.model.Operadora;
import br.com.medclin.model.TipoContato;
import br.com.medclin.model.TipoPlanoSaude;

@Configuration
public class AuditoriaUtil {

	private final String FLAG_SIM = "S";

	public void setDadosAuditoriaCriacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setFlagAtivo(FLAG_SIM);
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
			((Especialidade) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof TipoContato) {
			((TipoContato) entidade).setDataUltimaAlteracao(new Date());
			((TipoContato) entidade).setFlagAtivo(FLAG_SIM);
			((TipoContato) entidade).setUsuarioUltimaAlteracao(matricula);
			((TipoContato) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof TipoPlanoSaude) {
			((TipoPlanoSaude) entidade).setDataUltimaAlteracao(new Date());
			((TipoPlanoSaude) entidade).setFlagAtivo(FLAG_SIM);
			((TipoPlanoSaude) entidade).setUsuarioUltimaAlteracao(matricula);
			((TipoPlanoSaude) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof Operadora) {
			((Operadora) entidade).setDataUltimaAlteracao(new Date());
			((Operadora) entidade).setFlagAtivo(FLAG_SIM);
			((Operadora) entidade).setUsuarioUltimaAlteracao(matricula);
			((Operadora) entidade).setDataCriacao(new Date());
		}
	}

	public void setDadosAuditoriaAtualizacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof TipoContato) {
			((TipoContato) entidade).setDataUltimaAlteracao(new Date());
			((TipoContato) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof TipoPlanoSaude) {
			((TipoPlanoSaude) entidade).setDataUltimaAlteracao(new Date());
			((TipoPlanoSaude) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof Operadora) {
			((Operadora) entidade).setDataUltimaAlteracao(new Date());
			((Operadora) entidade).setUsuarioUltimaAlteracao(matricula);
		}
	}
}
