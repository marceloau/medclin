package br.com.medclin.common;

public enum StatusConsultaEnum {
	
	ABERTA(1),
	CONFIRMADA(2),
	AGUARDANDO_ATENDIMENTO(3),
	EM_ATENDIMENTO(4),
	FINALIZADA(5),
	CANCELADA(6);
	
	/**
	 * Integer for codigo status consulta.
	 */
	private Integer codigo;

	/**
	 * StatusConsulta enum constructor.
	 * 
	 * @param value - Integer valor do código.
	 */
	StatusConsultaEnum(final Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * Esse método retorna o código do enum.
	 * 
	 * @return Integer valor - o codigo do enum.
	 */
	public Integer getCodigo() {
		return this.codigo;
	}

}
