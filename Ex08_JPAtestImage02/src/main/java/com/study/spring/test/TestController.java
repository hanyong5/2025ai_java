package com.study.spring.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ResponseEntity<Map<String,String>> testCreate(
			@ModelAttribute TestDto request
			) throws IllegalStateException, IOException {

		Map<String,String> response = new HashMap<>();
		
		try {
			testService.testCreate(request);
			response.put("message","ok");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (Exception e) {
			response.put("message","error");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
//	@GetMapping("/test")
//	public List<TestEntity> testList(){
//		List<TestEntity> data = testService.findAll();
//		return data;
//	}
	
	@GetMapping("/test")
	public List<TestResponseDto> testList(){
		List<TestResponseDto> data = testService.findAll();
		return data;
	}
	

	
	
	
}
