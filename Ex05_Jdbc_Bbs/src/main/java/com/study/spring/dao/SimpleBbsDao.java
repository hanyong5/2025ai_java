package com.study.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.spring.dto.SimpleBbsDto;


@Repository
public class SimpleBbsDao implements ISimpleBbsDao {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("------------ writeDao 실행 ---------");
		String query = "insert into simple_bbs (writer,title,content)" + 
						"values (?,?,?)";
		
		return template.update(query,writer,title,content);
	}

	@Override
	public List<SimpleBbsDto> listDao() {
		System.out.println("--------------- listDao 실행 ---------------");
		String query = "select * from simple_bbs order by id desc";
		
		List<SimpleBbsDto> list = template.query(
				query, new BeanPropertyRowMapper<>(SimpleBbsDto.class)
				);

		return list;
	}

}
