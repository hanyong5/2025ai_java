package com.study.spring.test;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestDto {
	private String title;
	private String name;
	private String content;
	private List<MultipartFile> files;
}
