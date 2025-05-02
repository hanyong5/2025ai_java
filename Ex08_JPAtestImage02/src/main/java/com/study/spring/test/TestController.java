package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@Value("${file.upload-dir}")
	private String uploadDir;

	@GetMapping("/")
	public String root() {
		return "hi";
	}

//  01	
//	@PostMapping("/test")
//	public String testCreate(
//			@ModelAttribute TestDto request
//			) {
//		
//		System.out.println(request.toString());
//		
//		return null;
//	}

// 02	
//	@PostMapping("/test")
//	public String testCreate(
//			@ModelAttribute TestDto request
//			) throws IllegalStateException, IOException {
//
//		testService.testCreate(request);
//		return null;
//	}

// 03	
	@PostMapping("/test")
	public ResponseEntity<Map<String, String>> testCreate(@ModelAttribute TestDto request)
			throws IllegalStateException, IOException {

		Map<String, String> response = new HashMap<>();

		try {
			testService.testCreate(request);
			response.put("message", "ok");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (Exception e) {
			response.put("message", "error");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	}

// #1
//	@GetMapping("/test")
//	public List<TestEntity> testList(){
//		List<TestEntity> data = testService.findAll();
//		return data;
//	}

// #2
//	@GetMapping("/test")
//	public List<TestResponseDto> testList(){
//		List<TestResponseDto> data = testService.findAll();
//		return data;
//	}

// #3	
	@GetMapping("/test")
	public ResponseEntity<Page<TestResponseDto>> testList(
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<TestResponseDto> data = testService.findAll(pageable);
		return ResponseEntity.ok(data);
	}

	// http://localhost:8080/images/thumb_28cee97b...jpg
	// react / <img src={`http://localhost:8080/images/thum_${item.filename}`}>

	@GetMapping("/images/{filename}")
	public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename) throws IOException {
		File file = new File(uploadDir + filename);

		if (!file.exists()) {
			return ResponseEntity.notFound().build();
		}

		Resource resource = new FileSystemResource(file);

		String contentType = Files.probeContentType(file.toPath());

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);

	}

}
