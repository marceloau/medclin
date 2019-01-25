package br.com.medclin.common;

public enum PerfilEnum {
	
	ADMIN(1,"ROLE_ADM"),

	RECEP(2, "ROLE_RECEP");

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

}
