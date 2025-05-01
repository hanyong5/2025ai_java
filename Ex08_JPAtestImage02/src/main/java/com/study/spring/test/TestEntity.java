package com.study.spring.test;

import java.time.LocalDateTime;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="testimage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String name;
	private String content;
	private LocalDateTime localdate;
	private String imageFileNames;
	
	
}
