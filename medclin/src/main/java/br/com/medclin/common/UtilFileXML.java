package br.com.medclin.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class UtilFileXML {

	public static String criarArquivoXMLImpressao(final String metadados, final String localArmazenamento, final String nomeArquivo) {
		
        final String caminhoArquivoXML = localArmazenamento + nomeArquivo +".xml";
        
        File arquivo = new File(caminhoArquivoXML);
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(metadados.getBytes());
            gravar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }  
		
		return caminhoArquivoXML;
	}
}
