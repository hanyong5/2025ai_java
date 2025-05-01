package com.study.spring.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResponseDto {
	private Long id;
	private String title;
	private String name;
	private String content;
	private LocalDateTime localdate;
	private List<String> imageFilse;
	
	public TestResponseDto(TestEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.name = entity.getName();
		this.localdate = entity.getLocaldate();
		
//		this.imageFilse = Arrays.stream().map().collect();
		if(entity.getImageFileNames() != null && !entity.getImageFileNames().isEmpty()) {
			this.imageFilse = Arrays
					.stream(entity.getImageFileNames().split(","))
					.map(String::trim)
					.collect(Collectors.toList());
		}else {
			this.imageFilse = new ArrayList<>();
		}
	}
	
}
