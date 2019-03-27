package br.com.medclin.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import br.com.medclin.model.ebo.ImpressaoEBO;

public final class UtilFileXML {

	public static String criarArquivoXMLImpressao(final String localArmazenamento, final String nomeArquivo, final Object ebo) {
		
		XStream xStream = new XStream();
        xStream.alias("impressao", ImpressaoEBO.class);
 
        File arquivo = new File("C://porto//arquivo.xml");
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(ebo).getBytes());
            gravar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
		
		return "C://porto//arquivo.xml";
	}	
}
