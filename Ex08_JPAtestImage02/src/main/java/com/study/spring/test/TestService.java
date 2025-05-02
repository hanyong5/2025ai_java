package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;

	@Value("${file.upload-dir}")
	private String uploadDir;

	public void testCreate(TestDto dto) throws IllegalStateException, IOException {

		File dir = new File(uploadDir);
		if (!dir.exists()) {
			dir.mkdir();
		}

		List<String> savedFileNames = new ArrayList<>();

		if (dto.getFiles() != null && !dto.getFiles().isEmpty()) {
			for (MultipartFile file : dto.getFiles()) {
				if (file != null && !file.isEmpty()) {
					try {
						// 1. 파일이름처리
						String originalName = file.getOriginalFilename();
						String uuid = UUID.randomUUID().toString();
						String extension = originalName.substring(originalName.lastIndexOf("."));
						String storeFileName = uuid + extension;
						String thumbnailFileName = "thumb_" + uuid + extension;

						// 2. 파일업로드/썸네일업로드
						File saveFile = new File(uploadDir + storeFileName);
						file.transferTo(saveFile);
						
						File thumbnailFile = new File(uploadDir + thumbnailFileName);
						Thumbnails.of(saveFile).size(150, 150).toFile(thumbnailFile);
						
						// 3. 변경이름 저장
						savedFileNames.add(storeFileName);
						
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("파일저장 또는 썸네일 생성 오류 발생");
					}
				}
			}
		} //if end
		
		System.out.println(savedFileNames.toString());
		
		TestEntity entity = new TestEntity();
		entity.setTitle(dto.getTitle());
		entity.setName(dto.getName());
		entity.setContent(dto.getContent());
		entity.setLocaldate(LocalDateTime.now());
		entity.setImageFileNames(String.join(",", savedFileNames));
		
		testRepository.save(entity);
		
	}

//	public List<TestResponseDto> findAll() {
//		
//		return testRepository.findAll()
//				.stream()
//				.map(entity -> new TestResponseDto(entity))
//				.map(TestResponseDto::new)
//				.collect(Collectors.toList());
//	}

	public Page<TestResponseDto> findAll(Pageable pageable) {
		return testRepository.findAll(pageable)
				.map(TestResponseDto::new);
	}

	public Page<TestResponseDto> findAll(String query, Pageable pageable) {
		return testRepository.findByTitleContainingIgnoreCase(query,pageable);
	}



}
