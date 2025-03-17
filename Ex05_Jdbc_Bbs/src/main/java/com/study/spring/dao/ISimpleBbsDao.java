package com.study.spring.dao;

public interface ISimpleBbsDao {
	//write - int
	public int writeDao(String writer,String title,String content);
	//list - List<SimpleBbsDto>
	//view - SimpleBbsDto 
	//delete - int
}
