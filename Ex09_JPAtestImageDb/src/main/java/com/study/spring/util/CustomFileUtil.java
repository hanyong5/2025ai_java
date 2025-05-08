package com.study.spring.util;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;


@Component
@Log4j2
public class CustomFileUtil {

	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@PostConstruct
	public void init() {
		File dir = new File(uploadDir);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		uploadDir = dir.getAbsolutePath();

		log.info("---------------start1-----------------");
		log.info(uploadDir);
		
	}
	
	
	public List<String> uploadFile(List<MultipartFile> files) throws RuntimeException{
		
		if(files == null || files.size() == 0) {
			return null;
		}
		
		
		List<String> uploadNames = new ArrayList<>();
		
		for(MultipartFile file:files) {
			
			String savedName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			Path savePath = Paths.get(uploadDir,savedName);
			
			try {
				Files.copy(file.getInputStream(),savePath);
				
				String contentType = file.getContentType();
				
				if(contentType != null && contentType.startsWith("image")) {
					
					Path thumbnailPath = Paths.get(uploadDir,"thumb_" + savedName);
					Thumbnails.of(savePath.toFile()).size(150, 150).toFile(thumbnailPath.toFile());
				}
				
				uploadNames.add(savedName);
				
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			
		}
		return uploadNames;
	}
	
	
	public ResponseEntity<Resource> getFile(String fileName){
		
		Resource resource = new FileSystemResource(uploadDir + File.separator + fileName);
		
		if(!resource.exists()) {
			resource = new FileSystemResource(uploadDir + File.separator  + "default.png");
		}
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("content-type", Files.probeContentType(resource.getFile().toPath()));
		} catch (IOException e) {
			return ResponseEntity.internalServerError().build();
		}
		
		
		return ResponseEntity.ok().headers(headers).body(resource);
	}
	
	
	
	
	
}
