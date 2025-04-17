package com.study.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.dto.TestDto;
import com.study.spring.entity.TestEntity;
import com.study.spring.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/")
	public String test() {
		return "hello spring";
	}
	
	@PostMapping("/test")
	public void createPostTest(
			@RequestBody TestDto request
			) {
		testService.createPost(request);
	}
	
	@GetMapping("/test")
	public List<TestEntity> testList(){
		return testService.findAll();
	}

}
