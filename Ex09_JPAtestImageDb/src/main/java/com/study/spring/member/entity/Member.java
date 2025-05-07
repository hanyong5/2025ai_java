package com.study.spring.member.entity;

import java.util.ArrayList;
import java.util.List;import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import com.study.spring.testImage.entity.TestEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	private String password;
	private String nickname;
	private String auth;
	
	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TestEntity> tests = new ArrayList<>();
}
