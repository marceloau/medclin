package br.com.medclin.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.Especialidade;
import br.com.medclin.model.EspecialidadeMedico;
import br.com.medclin.model.Exame;
import br.com.medclin.model.Medicamento;
import br.com.medclin.model.Medico;
import br.com.medclin.model.Operadora;
import br.com.medclin.model.Paciente;
import br.com.medclin.model.TipoContato;
import br.com.medclin.model.TipoExame;
import br.com.medclin.model.TipoMedicamento;
import br.com.medclin.model.TipoPlanoSaude;
import br.com.medclin.repository.ContatoPessoaRepository;
import br.com.medclin.repository.EspecialidadeMedicoRepository;
import br.com.medclin.repository.EspecialidadeRepository;
import br.com.medclin.repository.ExameRepository;
import br.com.medclin.repository.MedicamentoRepository;
import br.com.medclin.repository.MedicoRepository;
import br.com.medclin.repository.OperadoraRepository;
import br.com.medclin.repository.PacienteRepository;
import br.com.medclin.repository.TipoContatoRepository;
import br.com.medclin.repository.TipoExameRepository;
import br.com.medclin.repository.TipoMedicamentoRepository;
import br.com.medclin.repository.TipoPlanoSaudeRepository;

@Configuration
public class AuditoriaUtil {

	@Autowired
	private EspecialidadeRepository especialidadeRep;

	@Autowired
	private EspecialidadeMedicoRepository especialidadeMedicoRep;

	@Autowired
	private TipoContatoRepository tipoContatoRep;

	@Autowired
	private TipoPlanoSaudeRepository tipoPlanoSaudeRep;

	@Autowired
	private OperadoraRepository operadoraRep;

	@Autowired
	private PacienteRepository pacienteRep;

	@Autowired
	private MedicoRepository medicoRep;

	@Autowired
	private ContatoPessoaRepository contatoPessoaRep;

	@Autowired
	private ExameRepository exameRep;

	@Autowired
	private TipoExameRepository tipoExameRep;

	@Autowired
	private MedicamentoRepository medicamentoRep;

	@Autowired
	private TipoMedicamentoRepository tipoMedicamentoRep;

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
		} else if (entidade instanceof Paciente) {
			((Paciente) entidade).setDataUltimaAlteracao(new Date());
			((Paciente) entidade).setFlagAtivo(FLAG_SIM);
			((Paciente) entidade).setUsuarioUltimaAlteracao(matricula);
			((Paciente) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof Medico) {
			((Medico) entidade).setDataUltimaAlteracao(new Date());
			((Medico) entidade).setFlagAtivo(FLAG_SIM);
			((Medico) entidade).setUsuarioUltimaAlteracao(matricula);
			((Medico) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof ContatoPessoa) {
			((ContatoPessoa) entidade).setDataUltimaAlteracao(new Date());
			((ContatoPessoa) entidade).setFlagAtivo(FLAG_SIM);
			((ContatoPessoa) entidade).setUsuarioUltimaAlteracao(matricula);
			((ContatoPessoa) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof EspecialidadeMedico) {
			((EspecialidadeMedico) entidade).setDataUltimaAlteracao(new Date());
			((EspecialidadeMedico) entidade).setFlagAtivo(FLAG_SIM);
			((EspecialidadeMedico) entidade).setUsuarioUltimaAlteracao(matricula);
			((EspecialidadeMedico) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof Exame) {
			((Exame) entidade).setDataUltimaAlteracao(new Date());
			((Exame) entidade).setFlagAtivo(FLAG_SIM);
			((Exame) entidade).setUsuarioUltimaAlteracao(matricula);
			((Exame) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof TipoExame) {
			((TipoExame) entidade).setDataUltimaAlteracao(new Date());
			((TipoExame) entidade).setFlagAtivo(FLAG_SIM);
			((TipoExame) entidade).setUsuarioUltimaAlteracao(matricula);
			((TipoExame) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof Medicamento) {
			((Medicamento) entidade).setDataUltimaAlteracao(new Date());
			((Medicamento) entidade).setFlagAtivo(FLAG_SIM);
			((Medicamento) entidade).setUsuarioUltimaAlteracao(matricula);
			((Medicamento) entidade).setDataCriacao(new Date());
		} else if (entidade instanceof TipoMedicamento) {
			((TipoMedicamento) entidade).setDataUltimaAlteracao(new Date());
			((TipoMedicamento) entidade).setFlagAtivo(FLAG_SIM);
			((TipoMedicamento) entidade).setUsuarioUltimaAlteracao(matricula);
			((TipoMedicamento) entidade).setDataCriacao(new Date());
		}
	}

	public void setDadosAuditoriaAtualizacao(final Object entidade, final String matricula) {
		if (entidade instanceof Especialidade) {
			((Especialidade) entidade).setDataUltimaAlteracao(new Date());
			((Especialidade) entidade).setDataCriacao(
					especialidadeRep.buscarDataCriacaoPorCodigo(((Especialidade) entidade).getCodigoEspecialidade()));
			((Especialidade) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof TipoContato) {
			((TipoContato) entidade).setDataUltimaAlteracao(new Date());
			((TipoContato) entidade).setDataCriacao(
					tipoContatoRep.buscarDataCriacaoPorCodigo(((TipoContato) entidade).getCodigoTipoContato()));
			((TipoContato) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof TipoPlanoSaude) {
			((TipoPlanoSaude) entidade).setDataUltimaAlteracao(new Date());
			((TipoPlanoSaude) entidade).setDataCriacao(
					tipoPlanoSaudeRep.buscarDataCriacaoPorCodigo(((TipoPlanoSaude) entidade).getCodigoTipoPlano()));
			((TipoPlanoSaude) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof Operadora) {
			((Operadora) entidade).setDataUltimaAlteracao(new Date());
			((Operadora) entidade).setDataCriacao(
					operadoraRep.buscarDataCriacaoPorCodigo(((Operadora) entidade).getCodigoOperadora()));
			((Operadora) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof Paciente) {
			((Paciente) entidade).setDataUltimaAlteracao(new Date());
			((Paciente) entidade)
					.setDataCriacao(pacienteRep.buscarDataCriacaoPorCodigo(((Paciente) entidade).getCodigoPessoa()));
			((Paciente) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof Medico) {
			((Medico) entidade).setDataUltimaAlteracao(new Date());
			((Medico) entidade)
					.setDataCriacao(medicoRep.buscarDataCriacaoPorCodigo(((Medico) entidade).getCodigoPessoa()));
			((Medico) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof ContatoPessoa) {
			((ContatoPessoa) entidade).setDataUltimaAlteracao(new Date());
			((ContatoPessoa) entidade).setDataCriacao(
					contatoPessoaRep.buscarDataCriacaoPorCodigo(((ContatoPessoa) entidade).getContatoPessoaPK()));
			((ContatoPessoa) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof EspecialidadeMedico) {
			((EspecialidadeMedico) entidade).setDataUltimaAlteracao(new Date());
			((EspecialidadeMedico) entidade).setDataCriacao(especialidadeMedicoRep
					.buscarDataCriacaoPorCodigo(((EspecialidadeMedico) entidade).getEspecialidadeMedicoPK()));
			((EspecialidadeMedico) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof Exame) {
			((Exame) entidade).setDataUltimaAlteracao(new Date());
			((Exame) entidade).setDataCriacao(exameRep
					.buscarDataCriacaoPorCodigo(((Exame) entidade).getCodigoExame()));
			((Exame) entidade).setUsuarioUltimaAlteracao(matricula);
		}else if (entidade instanceof TipoExame) {
			((TipoExame) entidade).setDataUltimaAlteracao(new Date());
			((TipoExame) entidade).setDataCriacao(tipoExameRep
					.buscarDataCriacaoPorCodigo(((TipoExame) entidade).getCodigoTipoExame()));
			((TipoExame) entidade).setUsuarioUltimaAlteracao(matricula);
		}else if (entidade instanceof Medicamento) {
			((Medicamento) entidade).setDataUltimaAlteracao(new Date());
			((Medicamento) entidade).setDataCriacao(medicamentoRep
					.buscarDataCriacaoPorCodigo(((Medicamento) entidade).getCodigoMedicamento()));
			((Medicamento) entidade).setUsuarioUltimaAlteracao(matricula);
		} else if (entidade instanceof TipoMedicamento) {
			((TipoMedicamento) entidade).setDataUltimaAlteracao(new Date());
			((TipoMedicamento) entidade).setDataCriacao(tipoMedicamentoRep
					.buscarDataCriacaoPorCodigo(((TipoMedicamento) entidade).getCodigoTipoMedicamento()));
			((TipoMedicamento) entidade).setUsuarioUltimaAlteracao(matricula);
		}
	}

}
