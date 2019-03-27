package br.com.medclin.resources;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.medclin.business.interfaces.IS3Business;
import br.com.medclin.common.Util;

@RestController
@RequestMapping(value = "/medclin/file")
public class S3Resource {
	@Autowired
	IS3Business iS3Business;

	@PostMapping("/upload")
	public String uploadMultipartFile(@RequestParam("keyname") String keyName,
			@RequestParam("uploadfile") MultipartFile file) {
		iS3Business.uploadFile(keyName, file);
		return "Upload Successfully. -> KeyName = " + keyName;
	}

	/*
	 * Download Files
	 */
	@GetMapping("/download/{keyname}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String keyname) {
		ByteArrayOutputStream downloadInputStream = iS3Business.downloadFile(keyname);

		return ResponseEntity.ok().contentType(Util.contentType(keyname))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + keyname + "\"")
				.body(downloadInputStream.toByteArray());
	}
	
	@GetMapping("/listar")
	public List<String> listAllFiles(){
	  return iS3Business.listFiles();
	}
}
