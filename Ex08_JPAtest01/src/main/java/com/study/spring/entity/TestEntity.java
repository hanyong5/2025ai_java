package com.study.spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name="testtable")
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // primary key, auto increment
	
	private String name;
	private String email;
	private String title;
	private String content;
	private LocalDateTime datetime;
	private LocalDateTime udatetime;
	
	public void changeNameAndTitleAndContent(String name, String title, String content) {
		this.name = name;
		this.title = title;
		this.content = content;
		this.udatetime = LocalDateTime.now();
		
	}
	

	

	
}
