package com.study.spring.testImage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.spring.testImage.dto.TestDto;
import com.study.spring.testImage.dto.TestResponseDto;
import com.study.spring.testImage.service.TestService;
import com.study.spring.util.CustomFileUtil;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/test")
@Log4j2
public class TestController {
	
	@Autowired
	private CustomFileUtil fileUtil;
	
	@Autowired
	private TestService testService;
	
	@PostMapping("/")
	public Map<String, String> testPost(@ModelAttribute TestDto testDto) {
		System.out.println("post" + testDto);
		
		List<MultipartFile> files = testDto.getFiles();
		List<String> uploadedFileNames = fileUtil.uploadFile(files);
		
		testDto.setUploadedFileNames(uploadedFileNames);
		
		
		log.info("filenames : " + uploadedFileNames);
		
		testService.testInsert(testDto);
		
		return Map.of("result","success");
	}
	
	
	@GetMapping("/images/{fileName}")
	public ResponseEntity<Resource> viewFiles(@PathVariable("fileName") String fileName) {
		
		return fileUtil.getFile(fileName);
	}
	
//	@GetMapping("/")
//	public ResponseEntity<Map<String, Object>> testListView(){
//		List<TestResponseDto> testList = testService.getList();
//		return ResponseEntity.ok(Map.of("result","success","data",testList));
//	}
	
	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> testList(Pageable pageable){
		Page<TestResponseDto> testList = testService.getList(pageable);
		return ResponseEntity.ok(Map.of("result","success","data",testList));
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Map<String,Object>> testListView(
			@PathVariable("id") Long id
			){
		
		TestResponseDto test = testService.getById(id);
		
		return ResponseEntity.ok(Map.of("result","success","view",test));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> testDelete(
			@PathVariable("id") Long id
			){
		
		boolean isDeleted = testService.testDelete(id);
		
		if(isDeleted) {
			return ResponseEntity.ok(Map.of("rusult","success","deletedId",id));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Map.of("rusult","fail","message","해당자료를 없네요","id",id));
		}
		
	}
	
	
	
	
	
	
	
	
	

}
