package com.study.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


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

}
