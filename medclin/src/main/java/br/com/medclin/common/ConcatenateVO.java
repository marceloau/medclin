package br.com.medclin.common;

import java.util.ArrayList;
import java.util.List;

public class ConcatenateVO {

	private String outFileName;
	private List<String> AppendFiles = new ArrayList<String>();
	private String fileOutbox;

	// =====================================
	
	public String getOutFileName() {
		return outFileName;
	}

	public void setOutFileName(String outFileName) {
		this.outFileName = outFileName;
	}

	public List<String> getAppendFiles() {
		return AppendFiles;
	}

	public void setAppendFiles(List<String> appendFiles) {
		AppendFiles = appendFiles;
	}

	public String getFileOutbox() {
		return fileOutbox;
	}

	public void setFileOutbox(String fileOutbox) {
		this.fileOutbox = fileOutbox;
	}

	@Override
	public String toString() {
		return "ConcatenateVO [outFileName=" + outFileName + ", AppendFiles=" + AppendFiles + ", fileOutbox=" + fileOutbox + "]";
	}

}
