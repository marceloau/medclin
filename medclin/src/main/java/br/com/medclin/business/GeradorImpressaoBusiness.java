package br.com.medclin.business;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.common.ReportGenerate;
import br.com.medclin.common.ReportVO;
import br.com.medclin.common.UtilFileXML;

@Configuration
public class GeradorImpressaoBusiness {
	
	private Logger logger = LoggerFactory.getLogger(GeradorImpressaoBusiness.class);
	
	@Value("${medclin.caminho.armazenamento.pdf.impressoes}")
	private String localArmazenamentoPDFImpressao;
	
	@Value("${medclin.caminho.armazenamento.xml.impressoes}")
	private String localArmazenamentoXMLImpressao;
	
	static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
	
	public File gerarArquivo(final String nomeArquivo, final String caminhoJasper, final String metadados, final String tipoArquivo) {
		
        String content = metadados;
        
        File retorno = null;

        ReportVO report = new ReportVO();
        report.setJasperFileSystem(caminhoJasper);
        report.setOutbox(localArmazenamentoPDFImpressao);
        report.setOutFileName(nomeArquivo);
        report.setOutFileType(tipoArquivo);
        report.setRecordPath("//impressao");
        StringBuilder sb = new StringBuilder();
        sb.append(content);
        report.setXmlDataSource(sb.toString());
        final String caminhoXML = UtilFileXML.criarArquivoXMLImpressao(metadados, localArmazenamentoXMLImpressao, nomeArquivo);
        logger.info("Info - Gerador Impressão - Caminho do XML: " + caminhoXML);
        ReportGenerate reportGenerate = new ReportGenerate();
        try {
        	retorno = reportGenerate.generate(report, caminhoXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return retorno;
	}

}
