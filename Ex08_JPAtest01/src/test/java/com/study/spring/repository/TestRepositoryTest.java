package com.study.spring.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.entity.TestEntity;

@SpringBootTest
public class TestRepositoryTest {

	@Autowired
	private TestRepository testRepository;
	
	@Test
	public void testInsert() {
		for(var i=1;i<=10;i++) {
			TestEntity test = new TestEntity();
			test.setName("한성용"+i);
			test.setEmail("hanyong5"+i+"@test.com");
			test.setContent("자료입니다." + i);
			test.setTitle("test title" +i);
			test.setDatetime(LocalDateTime.now());
			
			testRepository.save(test);
		}
	}
}
