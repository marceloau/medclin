package br.com.medclin.model.ebo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.medclin.model.Especialidade;
import br.com.medclin.model.EspecialidadeMedico;
import br.com.medclin.model.EspecialidadeMedicoPK;
import br.com.medclin.model.Medico;
import br.com.medclin.model.ebo.MedicoEBO;

public class MedicoEBOConverter implements IEBOConverter<MedicoEBO, Medico> {

	@Override
	public MedicoEBO convertToType(Medico entityClass) {
		final MedicoEBO medicoEBO = new MedicoEBO();
		medicoEBO.setCodigoPessoa(entityClass.getCodigoPessoa());
		medicoEBO.setContatos(entityClass.getContatos());
		medicoEBO.setDataCriacao(entityClass.getDataCriacao());
		medicoEBO.setDataNascimento(entityClass.getDataNascimento());
		medicoEBO.setEnderecos(entityClass.getEnderecos());
		medicoEBO.setEstadoCivil(entityClass.getEstadoCivil());
		medicoEBO.setFlagAtivo(entityClass.getFlagAtivo());
		medicoEBO.setInformacaoAdicional(entityClass.getInformacaoAdicional());
		medicoEBO.setListaAgendaMedico(entityClass.getListaAgendaMedico());
		
		if(entityClass.getListaEspecialidadeMedico() != null && !entityClass.getListaEspecialidadeMedico().isEmpty()) {
		
			final List<Especialidade> listaEspecialidades = new ArrayList<Especialidade>();
			
			for(final EspecialidadeMedico especialidadeMedico : entityClass.getListaEspecialidadeMedico()) {
				final Especialidade especialidade = new Especialidade();
				especialidade.setCodigoEspecialidade(especialidadeMedico.getEspecialidadeMedicoPK().getCodigoEspecialidadeMedico());
				especialidade.setDataCriacao(especialidadeMedico.getDataCriacao());
				especialidade.setDataUltimaAlteracao(especialidadeMedico.getDataUltimaAlteracao());
				especialidade.setFlagAtivo(especialidadeMedico.getFlagAtivo());
				especialidade.setUsuarioUltimaAlteracao(especialidadeMedico.getUsuarioUltimaAlteracao());
				especialidade.setDescricaoEspecialidade(especialidadeMedico.getEspecialidade().getDescricaoEspecialidade());
				especialidade.setNomeEspecialidade(especialidadeMedico.getEspecialidade().getNomeEspecialidade());
				listaEspecialidades.add(especialidade);
			}			
			medicoEBO.setListaEspecialidadeMedico(listaEspecialidades);
		}
		medicoEBO.setNacionalidade(entityClass.getNacionalidade());
		medicoEBO.setNaturalidade(entityClass.getNaturalidade());
		medicoEBO.setNomePessoa(entityClass.getNomePessoa());
		medicoEBO.setNumeroCpf(entityClass.getNumeroCpf());
		medicoEBO.setNumeroCRM(entityClass.getNumeroCRM());
		medicoEBO.setNumeroRg(entityClass.getNumeroRg());
		medicoEBO.setOrgamEmissor(entityClass.getOrgamEmissor());
		medicoEBO.setSexo(entityClass.getSexo());
		medicoEBO.setUsuarioUltimaAlteracao(entityClass.getUsuarioUltimaAlteracao());
		return medicoEBO;
	}

	@Override
	public Medico convertToEntity(MedicoEBO typeClass) {
		final Medico medico = new Medico();
		medico.setCodigoPessoa(typeClass.getCodigoPessoa());
		medico.setContatos(typeClass.getContatos());
		medico.setDataCriacao(typeClass.getDataCriacao());
		medico.setDataNascimento(typeClass.getDataNascimento());
		medico.setEnderecos(typeClass.getEnderecos());
		medico.setEstadoCivil(typeClass.getEstadoCivil());
		medico.setFlagAtivo(typeClass.getFlagAtivo());
		medico.setInformacaoAdicional(typeClass.getInformacaoAdicional());
		medico.setListaAgendaMedico(typeClass.getListaAgendaMedico());
		
		if(typeClass.getListaEspecialidadeMedico() != null && !typeClass.getListaEspecialidadeMedico().isEmpty()) {
		
			final List<EspecialidadeMedico> listaEspecialidades = new ArrayList<EspecialidadeMedico>();
			
			for(final Especialidade especialidade : typeClass.getListaEspecialidadeMedico()) {
				final EspecialidadeMedico especialidadeMedico = new EspecialidadeMedico();
				final EspecialidadeMedicoPK especialidadeMedicoPK = new EspecialidadeMedicoPK();
				
				especialidadeMedicoPK.setCodigoEspecialidadeMedico(especialidade.getCodigoEspecialidade());
				especialidadeMedicoPK.setCodigoPessoa(typeClass.getCodigoPessoa());
				
				especialidadeMedico.setEspecialidadeMedicoPK(especialidadeMedicoPK);
				especialidadeMedico.setDataCriacao(especialidade.getDataCriacao());
				especialidadeMedico.setDataUltimaAlteracao(especialidade.getDataUltimaAlteracao());
				especialidadeMedico.setEspecialidade(especialidade);
				especialidadeMedico.setFlagAtivo(especialidade.getFlagAtivo());
				especialidadeMedico.setMedico(medico);
				especialidadeMedico.setUsuarioUltimaAlteracao(especialidade.getUsuarioUltimaAlteracao());
				listaEspecialidades.add(especialidadeMedico);
			}			
			medico.setListaEspecialidadeMedico(listaEspecialidades);
		}
		medico.setNacionalidade(typeClass.getNacionalidade());
		medico.setNaturalidade(typeClass.getNaturalidade());
		medico.setNomePessoa(typeClass.getNomePessoa());
		medico.setNumeroCpf(typeClass.getNumeroCpf());
		medico.setNumeroCRM(typeClass.getNumeroCRM());
		medico.setNumeroRg(typeClass.getNumeroRg());
		medico.setOrgamEmissor(typeClass.getOrgamEmissor());
		medico.setSexo(typeClass.getSexo());
		medico.setUsuarioUltimaAlteracao(typeClass.getUsuarioUltimaAlteracao());
		return medico;
	}

	@Override
	public List<MedicoEBO> convertToType(List<Medico> entityClasses) {
		final List<MedicoEBO> listaMedicoEBO = new ArrayList<MedicoEBO>();
		if(entityClasses != null && !entityClasses.isEmpty()) {
			for(final Medico medico : entityClasses) {
				listaMedicoEBO.add(this.convertToType(medico));
			}
		}
		return listaMedicoEBO;
	}

	@Override
	public List<Medico> convertToEntity(List<MedicoEBO> typeClasses) {
		final List<Medico> listaMedico = new ArrayList<Medico>();
		if(typeClasses != null && !typeClasses.isEmpty()) {
			for(final MedicoEBO medicoEBO : typeClasses) {
				listaMedico.add(this.convertToEntity(medicoEBO));
			}
		}
		return listaMedico;
	}

	@Override
	public MedicoEBO convertToType(Medico entityClass, String[] campos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicoEBO> convertToType(List<Medico> entityClasses, String[] campos) {
		// TODO Auto-generated method stub
		return null;
	}

}
