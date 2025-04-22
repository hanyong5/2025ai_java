package com.study.spring.test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class TestImageService {
	
	@Autowired
	public TestImageRepository testImageRepository;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	

	public void testImageCreate(TestImageDto testImageDto) {
		TestImageEntity createData = new TestImageEntity();
		createData.setName(testImageDto.getName());
		createData.setTitle(testImageDto.getTitle());
		createData.setContent(testImageDto.getContent());
		createData.setStartdate(LocalDateTime.now());
		
		MultipartFile fileImage = testImageDto.getFiles();
		
		if(fileImage != null && !fileImage.isEmpty()) {
			System.out.println("파일이름 : " + fileImage.getOriginalFilename());
			System.out.println("파일크기 : " + fileImage.getSize());
			System.out.println("파일타입 : " + fileImage.getContentType());
			
			try {
				
				//1. 폴더생성
				File folder = new File(uploadDir);
				if(!folder.exists()) {
					folder.mkdir();
				}
				
				//2. 파일이름처리
				String originalName = fileImage.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				String extension = originalName.substring(originalName.lastIndexOf("."));
				String storeFileName = uuid + extension;
				String thumbnailFileName = "thumb_" + uuid + extension;
				
				
				
				System.out.println("파일명생성 : "+storeFileName);
				
				//3. 원본파일저장
				File originFile = new File(uploadDir+ File.separator + storeFileName);
				fileImage.transferTo(originFile);
				
				
				//4.thumbnail
				File thumbnailFile = new File(uploadDir+ File.separator + thumbnailFileName);
				Thumbnails.of(originFile).size(150, 150).toFile(thumbnailFile);
				
				
				
				//4. createData 넣기
				createData.setImageFileNames(storeFileName);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}else {
			System.out.println("파일이 없네요!!!");
		}
		
		System.out.println("entity : " + createData.toString());
		
		//db 저장완료
		testImageRepository.save(createData);
		
		
	}


	public Page<TestImageEntity> findAll(Pageable pageable) {
//		List<TestImageEntity>  data =testImageRepository.findAll();
		return testImageRepository.findAll(pageable);
	}

}
