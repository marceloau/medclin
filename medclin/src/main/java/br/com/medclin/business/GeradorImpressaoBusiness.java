package br.com.medclin.business;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.common.ReportGenerate;
import br.com.medclin.common.ReportVO;
import br.com.medclin.common.UtilFileXML;

@Configuration
public class GeradorImpressaoBusiness {
	
	static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
	
	public File gerarArquivo(final String nomeArquivo, final String caminhoJasper, final String metadados, final String tipoArquivo) {
		
        String content = metadados;
        
        File retorno = null;

        ReportVO report = new ReportVO();
        //report.setJasperFileSystem("C://Users//danilo.da.silva//JaspersoftWorkspace//MyReports//Emissao-Transportes//Impressao//Porto//Proposta//IMP-110//IMP-110.jasper");
        report.setJasperFileSystem(caminhoJasper);
        report.setOutbox("C://Servidor//Aplicações//Medclin//impressoes//pdf//");
        report.setOutFileName(nomeArquivo);
        report.setOutFileType(tipoArquivo);
        report.setRecordPath("//impressao");
        StringBuilder sb = new StringBuilder();
        sb.append(content);
        report.setXmlDataSource(sb.toString());
        final String caminhoXML = UtilFileXML.criarArquivoXMLImpressao(metadados, "C://Servidor//Aplicações//Medclin//impressoes//xml//", nomeArquivo);
        //final String caminhoXML = UtilFileXML.criarArquivoXMLImpressao(metadados, "C://porto//", nomeArquivo, objetoImpressao);
        ReportGenerate reportGenerate = new ReportGenerate();
        try {
        	retorno = reportGenerate.generate(report, caminhoXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return retorno;
	}

}
