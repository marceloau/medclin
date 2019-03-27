package br.com.medclin.common;

public class ReportVO {
	private String jasperFileSystem;
	private String outFileName;
	private String outFileType;
	private String recordPath;
	private String xmlDataSource;
	private String outbox;

	// =====================================

	public String getJasperFileSystem() {
		return jasperFileSystem;
	}

	public void setJasperFileSystem(String jasperFileSystem) {
		this.jasperFileSystem = jasperFileSystem;
	}

	public String getOutFileName() {
		return outFileName;
	}

	public void setOutFileName(String outFileName) {
		this.outFileName = outFileName;
	}

	public String getOutFileType() {
		if (outFileType != null && !outFileType.isEmpty()) {
			outFileType = outFileType.toLowerCase();
		}
		return outFileType;
	}

	public void setOutFileType(String outFileType) {
		this.outFileType = outFileType;
	}

	public String getRecordPath() {
		return recordPath;
	}

	public void setRecordPath(String recordPath) {
		this.recordPath = recordPath;
	}

	public String getXmlDataSource() {
		return xmlDataSource;
	}

	public void setXmlDataSource(String xmlDataSource) {
		this.xmlDataSource = xmlDataSource;
	}

	public String getOutbox() {
		return outbox;
	}

	public void setOutbox(String outbox) {
		this.outbox = outbox;
	}

	public String generatorToXML() {
		StringBuffer text = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?><report>");
		if (jasperFileSystem == null || jasperFileSystem.equalsIgnoreCase("")) {
			text.append("<jasperFileSystem />");
		} else {
			text.append("<jasperFileSystem>");
			text.append(jasperFileSystem);
			text.append("</jasperFileSystem>");
		}
		if (outFileName == null || outFileName.equalsIgnoreCase("")) {
			text.append("<outFileName />");
		} else {
			text.append("<outFileName>");
			text.append(outFileName);
			text.append("</outFileName>");
		}
		if (outFileType == null || outFileType.equalsIgnoreCase("")) {
			text.append("<outFileType />");
		} else {
			text.append("<outFileType>");
			text.append(outFileType);
			text.append("</outFileType>");
		}
		if (recordPath == null || recordPath.equalsIgnoreCase("")) {
			text.append("<recordPath />");
		} else {
			text.append("<recordPath>");
			text.append(recordPath);
			text.append("</recordPath>");
		}
		if (xmlDataSource == null || xmlDataSource.equalsIgnoreCase("")) {
			text.append("<xmlDataSource />");
		} else {
			text.append("<xmlDataSource>");
			text.append(xmlDataSource);
			text.append("</xmlDataSource>");
		}
		if (outbox == null || outbox.equalsIgnoreCase("")) {
			text.append("<outbox />");
		} else {
			text.append("<outbox>");
			text.append(outbox);
			text.append("</outbox>");
		}
		text.append("</report>");

		return text.toString();

	}
}
