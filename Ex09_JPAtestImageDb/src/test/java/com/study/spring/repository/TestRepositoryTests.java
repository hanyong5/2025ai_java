package com.study.spring.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.testImage.entity.TestEntity;
import com.study.spring.testImage.repository.TestRepository;

@SpringBootTest
public class TestRepositoryTests {

	@Autowired
	private TestRepository testRepository;
	
	@Test
	public void testInsert() {
		TestEntity test = TestEntity.builder()
				.name("한성용")
				.title("안녕하세요")
				.content("testContent")
				.build();
		
		test.addImageString(UUID.randomUUID()+"_"+"test1.jpg");
		test.addImageString(UUID.randomUUID()+"_"+"test2.jpg");
		
		testRepository.save(test);
		
	}
}
