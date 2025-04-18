package com.study.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
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
	
	
	
	// http://localhost:8080/test?page=0&size=5
	@GetMapping("/test")
	public Page<TestEntity> testList(Pageable pageable){
		return testService.findAll(pageable);
	}
	
	@DeleteMapping("/test")
	public void testDelete(
			@RequestParam("id") Long id
			) {
		testService.delete(id);
	}
	
	@PutMapping("/test")
	public void testUpdate(
			@RequestParam("id") Long id,
			@RequestBody TestDto request
			) {
		testService.update(
				id,
				request.getName(),
				request.getTitle(),
				request.getContent()
				);
	}
	
	// test/search?query=안녕&page=0&size=5
	@GetMapping("/test/search")
	public ResponseEntity<Page<TestEntity>>  testSearchList(
			@RequestParam("query") String query, 
			Pageable pageable
			){
		Page<TestEntity> data = testService.search(query,pageable);
		
		
		return ResponseEntity.ok(data);
	}
	

	
	
	
	
	
	
	
	
	
}
