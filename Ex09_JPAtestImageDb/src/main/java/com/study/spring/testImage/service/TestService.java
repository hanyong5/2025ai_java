package com.study.spring.testImage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.testImage.dto.TestDto;
import com.study.spring.testImage.entity.TestEntity;
import com.study.spring.testImage.repository.TestRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TestService {

	@Autowired
	private TestRepository testRepository;

	public void testInsert(TestDto dto) {
		
//		TestEntity test = new TestEntity();
//		test.setName(dto.getName());
//		test.setTitle(dto.getTitle());
		
		TestEntity test = TestEntity.builder()
				.title(dto.getTitle())
				.name(dto.getName())
				.content(dto.getContent())
				.build();
		
		
		List<String> uploadedFileNames = dto.getUploadedFileNames() ;
		
		if(uploadedFileNames != null) {
			for(String fileName:uploadedFileNames) {
				test.addImageString(fileName);
				log.info("---------------- file name -----------------" + fileName);
				
			}
		}
		
		
		testRepository.save(test);
	}


	
	
}
