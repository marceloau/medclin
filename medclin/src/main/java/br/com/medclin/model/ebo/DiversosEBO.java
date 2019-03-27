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
import java.util.List;

import javax.xml.bind.annotation.XmlElement;



// TODO: Auto-generated Javadoc
/**
 * The Class DiversosType.
 */
public class DiversosEBO implements Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The diversos. */
	private List<ItemDiversosEBO> diversos;

    /**
     * Gets the item diversos type.
     *
     * @return the item diversos type
     */
    @XmlElement(name="Item")
	public List<ItemDiversosEBO> getItemDiversosType() {
		return diversos;
	}
	

	/**
	 * Sets the diversos.
	 *
	 * @param itemDiversos the new diversos
	 */
	public void setDiversos(final List<ItemDiversosEBO> itemDiversos) {
		this.diversos = itemDiversos;
	}


	/**
	 * Instantiates a new diversos type.
	 *
	 * @param itensDiversos the itens diversos
	 */
	public DiversosEBO(final List<ItemDiversosEBO> itensDiversos) {
		super();
		this.diversos = itensDiversos;
	}
	

	/**
	 * Instantiates a new diversos type.
	 */
	public DiversosEBO() {
		super();
	}

	
	
}
