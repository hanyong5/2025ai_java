package com.study.spring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.dto.TestDto;
import com.study.spring.entity.TestEntity;
import com.study.spring.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;

	public void createPost(TestDto request) {
		TestEntity testdata = new TestEntity();
		testdata.setName(request.getName());
		testdata.setEmail(request.getEmail());
		testdata.setTitle(request.getTitle());
		testdata.setContent(request.getContent());
		testdata.setDatetime(LocalDateTime.now());
		
		testRepository.save(testdata);
		
	}

}
