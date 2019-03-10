package br.com.medclin.common;

public enum PerfilEnum {
	
	PRF_ADMIN(1,"PRF_ADMIN"),
	PRF_RECEP(2, "PRF_RECEP"),
	PRF_MEDICO(3, "PRF_MEDICO");

	private Integer codigo;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	PerfilEnum(final Integer codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public static PerfilEnum toEnum(final Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(final PerfilEnum perfil : PerfilEnum.values()) {
			if(codigo.equals(perfil.getCodigo())) {
				return perfil;
			}
		}
		
		throw new IllegalArgumentException("Perfil do usuário inválido: " + codigo);
	}
	
	public static PerfilEnum toCodigo(final String nome) {
		if(nome == null) {
			return null;
		}
		
		for(final PerfilEnum perfil : PerfilEnum.values()) {
			if(nome.equals(perfil.getDescricao())) {
				return perfil;
			}
		}
		
		throw new IllegalArgumentException("Perfil do usuário inválido: " + nome);
	}

}
