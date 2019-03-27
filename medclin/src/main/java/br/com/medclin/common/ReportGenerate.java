package br.com.medclin.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
//import com.porto.arquitetura.api.filesystem.linuxwindows.commons.FileContent;
//import com.porto.arquitetura.api.filesystem.linuxwindows.commons.FileSystemUser;
//import com.porto.arquitetura.api.filesystem.linuxwindows.util.UtilFileSystemWindows;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ghost4j.converter.ConverterException;
import org.ghost4j.converter.PSConverter;
import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;

//import java.util.Properties;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

//import com.porto.security.cryptography.Cryptography;
//import com.porto.security.cryptography.CryptographyException;
@SuppressWarnings("deprecation")
public class ReportGenerate {

    private final String REPORTSERVICE_PROPERTIES_FILE;
    /*
	public Properties getProp() throws IOException {

		Properties props = new Properties();

		props.setProperty("arquitetura.report.service.domainAD", "PORTOSEGURO");
		props.setProperty("arquitetura.report.service.userAD", "f0117245");
		try {
			props.setProperty("arquitetura.report.service.passwordAD", Cryptography.encrypt("seguro10"));
		} catch (CryptographyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return props;

	}
     */
    private static Logger LOGGER = LogManager.getLogger(ReportGenerate.class);

    public ReportGenerate() {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Iniciando o construtor ReportGenerate() ...");
        }

        REPORTSERVICE_PROPERTIES_FILE = "/properties/reportservice.properties";

    }

    public File generate(ReportVO report, String caminhoXML) throws IOException, JRException, ConverterException, DocumentException {
//        Locale local = new Locale("en", "US");
//        Locale.setDefault(new Locale("en", "US"));

        DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance();
        JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");

        long initial = System.currentTimeMillis();
        OutputStream out = null;
        File retorno = null;

        LOGGER.debug("Iniciando execucao do metodo generate/ReportGenerate...");

        if (report.getJasperFileSystem() != null) {
            LOGGER.debug("Validando a leitura de um arquivo em maquina Windows...");
            LOGGER.debug("Paramentros do usuario recuperados do properties e setados no userNT");
            LOGGER.debug("Chamada da classe UtilFileSystem");
            LOGGER.debug("Chamada da classe FileContent");
            LOGGER.debug("Preparando o relatorio com o DataSource e o arquivo .jasper");

            JRXmlDataSource xml = new JRXmlDataSource(caminhoXML, "//impressao");

            Map parameters = new HashMap();
//            parameters.put(JRParameter.REPORT_LOCALE, Locale.US);

            JasperPrint print = JasperFillManager.fillReport(report.getJasperFileSystem(), parameters, xml);

            StringBuilder sbNameFile = new StringBuilder();
            sbNameFile.append(report.getOutbox()).append(report.getOutFileName()).append(".").append(report.getOutFileType());

            if (report.getOutFileType().equalsIgnoreCase("pdf")) {
                out = new FileOutputStream(sbNameFile.toString());
                JasperExportManager.exportReportToPdfStream(print, out);
                LOGGER.debug("Exportando o relatorio em PDF...");
            } else if (report.getOutFileType().equalsIgnoreCase("html")) {
                out = new FileOutputStream(sbNameFile.toString());
                JRXhtmlExporter exporter = new JRXhtmlExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporter.exportReport();
                LOGGER.debug("Exportando o relatorio em HTML...");
            } else if (report.getOutFileType().equalsIgnoreCase("docx")) {
                out = new FileOutputStream(sbNameFile.toString());
                JRDocxExporter exporterDOCX = new JRDocxExporter();
                exporterDOCX.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporterDOCX.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporterDOCX.exportReport();
                LOGGER.debug("Exportando o relatorio em DOCX...");
            } else if (report.getOutFileType().equalsIgnoreCase("xls")) {
                out = new FileOutputStream(sbNameFile.toString());
                JRXlsxExporter exporterXLS = new JRXlsxExporter();
                exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporterXLS.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporterXLS.exportReport();
                LOGGER.debug("Exportando o relatorio em XLS...");
            } else if (report.getOutFileType().equalsIgnoreCase("ppt")) {

                //out = file.FileWrite(sbNameFile.toString());
                out = new FileOutputStream(sbNameFile.toString());

                JRPptxExporter exporterPPT = new JRPptxExporter();

                exporterPPT.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporterPPT.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

                exporterPPT.exportReport();
                LOGGER.debug("Exportando o relatorio em PPT...");
            } else if (report.getOutFileType().equalsIgnoreCase("ps")) {
                LOGGER.debug("Entrou no if do PostScript....");
                out = new FileOutputStream(sbNameFile.toString());
                byte[] pdf = JasperExportManager.exportReportToPdf(print);
                LOGGER.debug("Exportou o relatorio em memoria...");
                ByteArrayInputStream bis = new ByteArrayInputStream(pdf);
                PDFDocument document = new PDFDocument();
                document.load(bis);
                PSConverter converter = new PSConverter();
                converter.convert(document, out);
                LOGGER.debug("Exportando o relatorio em PostScript...");
            } else if (report.getOutFileType().equalsIgnoreCase("txt")) {
                out = new FileOutputStream(sbNameFile.toString());
                JRTextExporter exporterTXT = new JRTextExporter();
                exporterTXT.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
                exporterTXT.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
                exporterTXT.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporterTXT.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                exporterTXT.exportReport();
                LOGGER.debug("Exportando o relatorio em TXT...");
            } else {
                LOGGER.debug("Extensao de arquivo invalido...");
            }
            if (out != null) {
                out.flush();
                out.close();
                retorno = new File(sbNameFile.toString());
            }
        } else {
            LOGGER.info("JasperFileSystem esta nulo");
        }
        LOGGER.debug("Tempo de escrita do arquivo :  [" + (System.currentTimeMillis() - initial) + " ms]");
        
        return retorno;
    }

}
