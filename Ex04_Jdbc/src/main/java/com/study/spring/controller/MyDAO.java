package com.study.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MyDTO> list(){
		String query = "select * from simple_bbs";
		List<MyDTO> list = 
				jdbcTemplate.query(
						query, new BeanPropertyRowMapper<>(MyDTO.class)
						);

		return list;
	}
}
