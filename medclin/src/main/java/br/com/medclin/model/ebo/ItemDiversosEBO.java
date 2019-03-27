/******************************************************************************* 
 * Copyright (c) 2014-2014, 2015 Porto Seguro Seguros S.A., Inc. All Rights Reserved.
 * 
 * Este software contém informações confidenciais e de propriedade da Porto Seguro Seguros S.A. ("Informações Confidenciais"). 
 * Você não deve divulgar qualquer tipo de informações confidenciais e deve usá-las apenas, de acordo com os termos do 
 * contrato de licença firmado com a Porto Seguro. 
 * 
 * A Porto Seguro não faz declarações ou garantias sobre a adequação do software, expressa ou implicitamente, incluindo, 
 * mas não se limitando, a garantias de comercialização, adequação para um determinado fim ou qualquer tipo de violação. 
 * 
 * A PORTO SEGURO NÃO SERÁ RESPONSÁVEL POR QUAISQUER DANOS SOFRIDOS PELO LICENCIADO EM DECORRÊNCIA DO USO, MODIFICAÇÃO 
 * OU DISTRIBUIÇÃO DESTE SOFTWARE OU SEUS DERIVADOS. 
 * 
 * 
 * Criado em(Created on): 25/04/2017 
 * Autor(Author)        : marcelo.aurino@accenture.com
 * 
 * ----------------------------------------------------------------------------- 
 * Histórico da Revisão (Revision History) - Release 1.0.0 
 * ----------------------------------------------------------------------------- 
 *  VERSÃO      DATA           AUTOR                DESCRIÇÃO DA MUDANÇA 
 * (VERSION)   (DATE)         (AUTHOR)             (DESCRIPTION OF CHANGE) 
 * ----------------------------------------------------------------------------- 
 * 1.0.0   | 25/04/2017 |   marcelo.aurino   | Criação Inicial (Initial Create) 
 * --------|------------|--------------------|---------------------------------- 
 *******************************************************************************/
package br.com.medclin.model.ebo;

import java.io.Serializable;


// TODO: Auto-generated Javadoc
/**
 * The Class ItemDiversosType.
 */
public class ItemDiversosEBO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5912883400919043928L;
	
	/** The chave. */
	private String chave;
	
	/** The valor. */
	private String valor;
	
	/**
	 * Gets the chave.
	 *
	 * @return the chave
	 */
	public String getChave() {
		return chave;
	}
	
	/**
	 * Sets the chave.
	 *
	 * @param chave the chave to set
	 */
	public void setChave(final String chave) {
		this.chave = chave;
	}
	
	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	
	/**
	 * Sets the valor.
	 *
	 * @param valor the valor to set
	 */
	public void setValor(final String valor) {
		this.valor = valor;
	}
	
	/**
	 * Instantiates a new item diversos type.
	 *
	 * @param chave the chave
	 * @param valor the valor
	 */
	public ItemDiversosEBO(final String chave, final String valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}
	
	/**
	 * Construtor.
	 */
	public ItemDiversosEBO() {
		super();
	}
		
}
