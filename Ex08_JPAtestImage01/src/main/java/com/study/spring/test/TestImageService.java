package com.study.spring.test;

import java.io.File;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TestImageService {
	
	@Autowired
	public TestImageRepository testImageRepository;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	

	public void testImageCreate(TestImageDto testImageDto) {
		TestImageEntity createData = new TestImageEntity();
		createData.setName(testImageDto.getName());
		createData.setTitle(testImageDto.getTitle());
		createData.setContent(testImageDto.getContent());
		createData.setStartdate(LocalDateTime.now());
		
		MultipartFile fileImage = testImageDto.getFiles();
		
		if(fileImage != null && !fileImage.isEmpty()) {
			System.out.println("파일이름 : " + fileImage.getOriginalFilename());
			System.out.println("파일크기 : " + fileImage.getSize());
			System.out.println("파일타입 : " + fileImage.getContentType());
			
			//디렉토리생성
			File folder = new File(uploadDir);
			if(!folder.exists()) {
				folder.mkdir();
			}
			
			
			
		}else {
			System.out.println("파일이 없네요!!!");
		}
		
		
		System.out.println("entity : " + createData.toString());
		
		
	}

}
