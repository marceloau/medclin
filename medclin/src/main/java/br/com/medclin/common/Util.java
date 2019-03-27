package br.com.medclin.common;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.http.MediaType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class Util {
	
	public static String gerarXMLs(final Class<?> estrutura, final Object valores) throws JAXBException {
		final JAXBContext context = JAXBContext.newInstance(estrutura);
		final Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		final StringWriter strWriter = new StringWriter();
		marshaller.marshal(valores, strWriter);
		return strWriter.toString();
	}
	
	public static String removeXmlStringNamespaceAndPreamble(final String xmlString) {
		return xmlString.replaceAll("(<\\?[^<]*\\?>)?", ""). /* remove preamble */
		replaceAll("xmlns.*?(\"|\').*?(\"|\')", "") /* remove xmlns declaration */
		.replaceAll("(<)(\\w+:)(.*?>)", "$1$3") /* remove opening tag prefix */
		.replaceAll("(</)(\\w+:)(.*?>)", "$1$3"); /* remove closing tags prefix */
	}
	
	public static String inserirParametrosFormulario(final String conteudo) {
		String conteudoComParametros = conteudo;
		
		String xml10pattern = "[^"
                + "\u0009\r\n"
                + "\u0020-\uD7FF"
                + "\uE000-\uFFFD"
                + "\ud800\udc00-\udbff\udfff"
                + "]";
		
		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			StringBuilder xmlStringBuilder = new StringBuilder(conteudo);
			ByteArrayInputStream input;
			input = new ByteArrayInputStream(
					xmlStringBuilder.toString().getBytes("UTF-8"));
			Document doc = builder.parse(input);
			Element root = doc.getDocumentElement();
			
			//include MQ tags
			Document newDoc = builder.newDocument();
			Element newRoot = newDoc.createElement("data");
	        newDoc.appendChild(newRoot);
	        Element file = newDoc.createElement("file");
	        newRoot.appendChild(file);
	        Element mqElement = newDoc.createElement("mq");
	        file.appendChild(mqElement);
	        mqElement.appendChild(newDoc.importNode(root, true));
			
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	        StringWriter writer = new StringWriter();
	        transformer.transform(new DOMSource(newDoc), new StreamResult(writer));
	        conteudoComParametros = writer.getBuffer().toString().replaceAll("\n|\r", "");
	        
		} catch (Exception  e) {
			e.printStackTrace();
		}
		
		return conteudoComParametros;
	}
	
	public static MediaType contentType(String keyname) {
		String[] arr = keyname.split("\\.");
		String type = arr[arr.length - 1];
		switch (type) {
		case "txt":
			return MediaType.TEXT_PLAIN;
		case "png":
			return MediaType.IMAGE_PNG;
		case "jpg":
			return MediaType.IMAGE_JPEG;
		case "pdf":
			return MediaType.APPLICATION_PDF;
		default:
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}

}
