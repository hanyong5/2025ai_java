package com.study.spring.test;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestImageService {
	
	@Autowired
	public TestImageRepository testImageRepository;

	public void testImageCreate(TestImageDto testImageDto) {
		TestImageEntity createData = new TestImageEntity();
		createData.setName(testImageDto.getName());
		createData.setTitle(testImageDto.getTitle());
		createData.setContent(testImageDto.getContent());
		createData.setStartdate(LocalDateTime.now());
		
	}

}
