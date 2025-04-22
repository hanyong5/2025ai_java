package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestImageController {
	
	@Autowired
	public TestImageService testImageService;
	
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	

	@GetMapping("/")
	public String root() {
		return "hi spring";
	}
	
	@PostMapping("/test")
	public void testCreate(@ModelAttribute TestImageDto testImageDto) {
		testImageService.testImageCreate(testImageDto);
	}
	
	// http://localhost:8080/images/thumb_28cee97b...jpg
	// react <img src={`http://localhost:8080/images/thum_${item.filename}`}>
	@GetMapping("/images/{filename}")
	public ResponseEntity<Resource> getImage(
			@PathVariable("filename") String filename
			) throws IOException  {
		
		File file = new File(uploadDir + filename);
//		System.out.println(file.toString());
		
		if(!file.exists()) {
			System.out.println("파일이 없네요!!!!!!");
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new FileSystemResource(file);
		
		String contentType = Files.probeContentType(file.toPath());
		
//		System.out.println(contentType.toString());
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);
	}
	
//	@GetMapping("/test")
//	public List<TestImageEntity> testLists(){
//		List<TestImageEntity> data = testImageService.findAll();
//		return data;
//		
//	}
	
	// page-> Pageable pageable, type->Page
	@GetMapping("/test")
	public ResponseEntity<Page<TestImageEntity>> testLists(
			@PageableDefault(size=2,sort="id",direction = Sort.Direction.DESC) Pageable pageable ){
		Page<TestImageEntity> data = testImageService.findAll(pageable);
		return ResponseEntity.ok(data);
		
	}

	
	
	
	
	
	
	
}
