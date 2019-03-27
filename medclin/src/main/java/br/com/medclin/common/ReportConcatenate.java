package br.com.medclin.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
//import java.util.Properties;


import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRPropertiesUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
//import com.porto.arquitetura.api.filesystem.linuxwindows.commons.FileContent;
//import com.porto.arquitetura.api.filesystem.linuxwindows.commons.FileSystemUser;
//import com.porto.arquitetura.api.filesystem.linuxwindows.util.UtilFileSystemWindows;
import org.apache.commons.vfs2.FileContent;
//import com.porto.security.cryptography.Cryptography;
//import com.porto.security.cryptography.CryptographyException;

public class ReportConcatenate {
/*
	private final String REPORTSERVICE_PROPERTIES_FILE;
	
	public Properties getProp() throws IOException {

		Properties props = new Properties();
		
		props.load(this.getClass().getResourceAsStream(REPORTSERVICE_PROPERTIES_FILE));
		return props;

	}
	*/
	private static Logger LOGGER = LogManager.getLogger(ReportConcatenate.class);
/*
	public ReportConcatenate() {

		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Iniciando o construtor ReportConcatenate() ...");
			
		}	
		REPORTSERVICE_PROPERTIES_FILE = "/properties/reportservice.properties";
	}	

	public void concatenate(ConcatenateVO concatenate) throws Exception {

		DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance();
		JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.xpath.executer.factory", "net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");

		LOGGER.debug("Iniciando a execucao do metodo concatenate/ReportConcatenate");

		LOGGER.debug("Validando a leitura de um arquivo em maquina Windows...");

		Properties prop = getProp();
		
		FileSystemUser userNT = new FileSystemUser();
		userNT.setDominioAD(prop.getProperty("arquitetura.report.service.domainAD"));
		userNT.setUsuarioAD(prop.getProperty("arquitetura.report.service.userAD"));

		// Chamada a fun��o da seguran�a, para descriptografar a senha
		
					String senha = null;
					try {
						senha =	Cryptography.decrypt(prop.getProperty("arquitetura.report.service.passwordAD"));
					} catch (CryptographyException e1) {
						e1.printStackTrace();
					}
					userNT.setSenhaAD(senha);

		UtilFileSystemWindows file = new UtilFileSystemWindows(userNT);

		
		if (concatenate.getAppendFiles() != null) {
		
			List<FileContent> fileContents = file.getFileContents(concatenate.getAppendFiles());

			OutputStream out = file.FileWrite(concatenate.getFileOutbox() + concatenate.getOutFileName() + ".pdf");

			LOGGER.debug("Chamada do metodo doMerge para concatenar os arquivos pdf");

			doMerge(fileContents, out);
		}
	}

	// -------------------------------------------------------------------

	public static void doMerge(List<FileContent> list, OutputStream outputStream) throws DocumentException, IOException {

		long initial = System.currentTimeMillis();
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		PdfContentByte cb = writer.getDirectContent();

		for (FileContent in : list) {
			PdfReader reader = new PdfReader(in.ConvertToInputStream());
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				document.newPage();
				// import the page from source pdf
				PdfImportedPage page = writer.getImportedPage(reader, i);
				// add the page to the destination pdf
				cb.addTemplate(page, 0, 0);
			}
		}

		outputStream.flush();
		document.close();
		outputStream.close();

		LOGGER.debug("Metodo doMerge executado com sucesso!");

		LOGGER.debug("Tempo de escrita do arquivo :  [" + (System.currentTimeMillis() - initial) + " ms]");

	}
*/
}
