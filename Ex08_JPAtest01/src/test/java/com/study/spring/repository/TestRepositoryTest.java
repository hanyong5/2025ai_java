package com.study.spring.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

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
	
//	@Test
//	public void testListView() {
//		// 데이터 조회
//        List<TestEntity> allTests = testRepository.findAll();
//     // 결과 출력 (optional)
//        allTests.forEach(test -> {
//            System.out.println("이름: " + test.getName() + ", 나이: " + test.getEmail());
//        });
//
//        // 실제로 내용이 있는지 테스트
//        assertNotNull(allTests);
//        assertFalse(allTests.isEmpty()); // 비어 있지 않아야 통과
//	}
	
}
