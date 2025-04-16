package com.study.spring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

	@GetMapping("/")
	public Map<String, String> Hello() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "hello world!!!");
		return response;
	}

	@GetMapping("/your")
	public Map<String, String> requestBody(@RequestParam("name") String name, @RequestParam("age") String age) {
		Map<String, String> response = new HashMap<>();
		response.put("name", name);
		response.put("age", age);
		return response;
	}

	@RestController
	public class TestRequestApi {
	    // Path Variable 방식
	    @GetMapping("/test/{name}/{age}")
	    public Map<String, Object> requestPathVariable(
	            @PathVariable("name") String name,
	            @PathVariable("age") Integer age
	    ) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "Hello, Path Variable");
	        response.put("name", name);
	        response.put("age", age);
	        return response;
	    }
	}
	
	
	@PostMapping("/your")
	public String request(@RequestBody TestRequest request) {
		return "Hello, Request Body, I am " + request.getName() + ", " + request.getAge();
	}

	
}
