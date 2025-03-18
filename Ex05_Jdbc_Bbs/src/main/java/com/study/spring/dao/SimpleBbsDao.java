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

	@Override
	public Integer countDao() {
		System.out.println("--------------- countDao() 실행 ---------------");
		
		String query = "select count(*) from simple_bbs";
		Integer count = template.queryForObject(query, Integer.class);
		return count;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("--------------- viewDao 실행 ---------------");
		String query = "select * from simple_bbs where id = " + id ;
		SimpleBbsDto view = template.queryForObject(
				query, new BeanPropertyRowMapper<>(SimpleBbsDto.class)
				);
		
		return view;
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("--------------- deleteDao 실행 --------------");
		String query = "delete from simple_bbs where id = ? ";
		
		return template.update(query, Integer.parseInt(id));
	}

}
