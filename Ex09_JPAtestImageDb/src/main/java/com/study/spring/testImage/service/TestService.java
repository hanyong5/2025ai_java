package com.study.spring.testImage.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.testImage.dto.TestDto;
import com.study.spring.testImage.dto.TestResponseDto;
import com.study.spring.testImage.entity.TestEntity;
import com.study.spring.testImage.entity.TestImage;
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

//	public List<TestResponseDto> getList() {
//		// TestEntity -> TestResponseDto (entity->dto)
//		List<TestEntity> tests = testRepository.findAll();
//		
//		
//		List<TestResponseDto> resultList = new ArrayList<>();
//		
//		for(TestEntity test:tests) {
//			
//			List<String> imageNames = new ArrayList<>();
//												
//			for(TestImage image:test.getImageList()) {
//				imageNames.add(image.getStoredName());
//			}
//			
//			TestResponseDto dto = new TestResponseDto(
//					test.getId(),
//					test.getName(),
//					test.getContent(),
//					test.getTitle(),
//					imageNames
//					);
//			resultList.add(dto);
//	
//		}
//
//		return resultList;
//	}
	
	public List<TestResponseDto> getList(){
		
		List<TestEntity> tests = testRepository.findAll();
		
//		List<TestResponseDto> resultList = tests.stream().map().toList();
		List<TestResponseDto> resultList = tests.stream()
				.map(test->{
					List<String> imageNames = test.getImageList().stream()
							.map(TestImage::getStoredName)
							.toList();
					
					return new TestResponseDto(
							test.getId(),
							test.getTitle(),
							test.getName(),
							test.getContent(),
							imageNames
							);
				})
				.toList();
		
		return resultList;
		
	}

	public Page<TestResponseDto> getList(Pageable pageable) {
		Page<TestEntity> tests = testRepository.findAll(pageable);

		Page<TestResponseDto> resultList = tests
				.map(test->{
					List<String> imageNames = test.getImageList().stream()
							.map(TestImage::getStoredName)
							.toList();
					
					return new TestResponseDto(
							test.getId(),
							test.getTitle(),
							test.getName(),
							test.getContent(),
							imageNames
							);
				});
		
		return resultList;
		
		
//		return testRepository.findAll(pageable)
//					.map(test->{
//					List<String> imageNames = test.getImageList().stream()
//							.map(TestImage::getStoredName)
//							.toList();
//					
//					return new TestResponseDto(
//							test.getId(),
//							test.getTitle(),
//							test.getName(),
//							test.getContent(),
//							imageNames
//							);
//				});
	}

	public TestResponseDto getById(Long id) {
		TestEntity test = testRepository.findById(id)
				.orElseThrow(()->new RuntimeException("not found"));
		
		List<String> imageNames = test.getImageList().stream()
				.map(TestImage::getStoredName).toList();
		
		return new TestResponseDto(
				test.getId(),
				test.getName(),
				test.getTitle(),
				test.getContent(),
				imageNames);
	}

	
	


	
	
	
	
	
	
	
	
	
	
	
}
