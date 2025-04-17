package com.study.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public List<TestEntity> findAll() {

		return testRepository.findAll();
	}



	
	
	

}
