package com.study.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestImageController {
	
	@Autowired
	public TestImageService testImageService;
	

	@GetMapping("/")
	public String root() {
		return "hi spring";
	}
	
	@PostMapping("/test")
	public void testCreate(@ModelAttribute TestImageDto testImageDto) {
		testImageService.testImageCreate(testImageDto);
	}
}
