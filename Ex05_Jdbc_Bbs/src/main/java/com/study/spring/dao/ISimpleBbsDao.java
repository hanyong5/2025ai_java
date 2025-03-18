package com.study.spring.dao;

import java.util.List;

import com.study.spring.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
	//write - int
	public int writeDao(String writer,String title,String content);

	
	//list - List<SimpleBbsDto>
	public List<SimpleBbsDto> listDao();

    //count - Integer(null이 나오면 안됨, 래퍼클래스)
	public Integer countDao();


	//view - SimpleBbsDto 
	public SimpleBbsDto viewDao(String id);


	//delete - int
	public int deleteDao(String id);

}
