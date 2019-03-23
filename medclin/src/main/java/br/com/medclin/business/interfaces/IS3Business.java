package br.com.medclin.business.interfaces;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IS3Business {
	public ByteArrayOutputStream downloadFile(String keyName);
	public void uploadFile(String keyName, MultipartFile file);
	public List<String> listFiles();
}
