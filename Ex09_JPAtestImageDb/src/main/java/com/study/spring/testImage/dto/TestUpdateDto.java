package com.study.spring.testImage.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestUpdateDto {
	private Long id;
	private String name;
	private String title;
	private String content;
	
	private List<String> updatedFileNames = new ArrayList<>();
	private List<MultipartFile> files = new ArrayList<>();
	private List<String> newUploadedFileNames = new ArrayList<>();
	
}
