package com.study.spring.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping("/")
	public String testApi() {
		return "hello!!! api";
	}
	
	@GetMapping("/test")
	public Map<String, String> testHello(){
		Map<String, String> response = new HashMap<>();
		response.put("message", "hello world!!!");
		response.put("test", "hello world222!!!");
		return response;
	}
	
// http://localhost:8080/test/{name}/{age} -> pathVariable
//	@GetMapping("/test/{name}/{age}")
//	public String TestRequest(
//			@PathVariable("name") String name,
//			@PathVariable("age") Integer age
//			) {
//		
//		
//		return "hello, i am " + name + ", age " + age;
//	}
	
	
	@GetMapping("/test/{name}/{age}")
	public Map<String, Object> TestRequest(
			@PathVariable("name") String name,
			@PathVariable("age") Integer age
			) {
		Map<String, Object> response = new HashMap<>();
		response.put("name", name);
		response.put("age", age);
		
		return response;
	}
	
	// http://localhost:8080/testApi?name=한성용&age=10
	@GetMapping("/test/param")
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") Integer age
			) {
		
		return "hello i am "+ name + ", age " + age;
	}
	
	@PostMapping("/test/body")
	public String requestBody(
			@RequestBody TestRequestDto request
			) {
		
		return "hello, request body, name " + request.getName()+ ", age " + request.getAge();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
