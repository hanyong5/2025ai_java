package com.study.spring.service;

import java.util.List;
import java.util.Map;

import com.study.spring.dto.SimpleBbsDto;

public interface ISimpleBbsService {

	void write(String writer, String title, String content);

	int count();

//	List<SimpleBbsDto> list(int size, int offset);

	Object view(String sId);

	void delete(String parameter);

	Map<String, Object> getPagedList(int page, int size);

	

}
