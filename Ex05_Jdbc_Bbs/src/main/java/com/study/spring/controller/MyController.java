package com.study.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.spring.dao.ISimpleBbsDao;
import com.study.spring.dto.SimpleBbsDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;

//	@RequestMapping("/")
//	public @ResponseBody String root() {
//		return "jdbc template";
//	}
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "bbs/writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		dao.writeDao(writer, title, content);
		
		System.out.println(writer + title + content);
		return "redirect:bbs/list";
	}
	
	//localhost:8080/list?page=2&size=10
	@RequestMapping("/list")
	public String list(
			HttpServletRequest request,
			Model model) {
		
		int page = Integer.parseInt(request.getParameter("page")); // 문자를 int변경
		int size = Integer.parseInt(request.getParameter("size"));
		
		int totalCount = dao.countDao();
		
		int totalPages = (int)Math.ceil((double) totalCount / size);
		
		List<SimpleBbsDto> list = dao.listDao(page,size);
				
				
				
		model.addAttribute("lists",list);
		model.addAttribute("totalCount",totalCount);
				
				
				
		return "bbs/list";
	}
	
	
	// http://localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		String sId = request.getParameter("id");
		
		model.addAttribute("dto",dao.viewDao(sId));
		
		return "bbs/view";
	}
	
	// http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public String Delete(
			HttpServletRequest request
			) {
		
		dao.deleteDao(request.getParameter("id"));
		
		return "redirect:bbs/list";
	}
	
	
	
	
	
	

}