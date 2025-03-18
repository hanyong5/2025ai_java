package com.study.spring.dao;

import java.util.List;

import com.study.spring.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
	//write - int
	public int writeDao(String writer,String title,String content);

	
	//list - List<SimpleBbsDto>
	public List<SimpleBbsDto> listDao();

	//view - SimpleBbsDto 
	//delete - int
}
