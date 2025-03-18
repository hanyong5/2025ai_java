package com.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.spring.dao.ISimpleBbsDao;

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
		return "redirect:list";
	}
	
	

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		dao.writeDao(writer, title, content);
		
		System.out.println(writer + title + content);
		return "redirect:list";
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists",dao.listDao());
		model.addAttribute("count",dao.countDao());
		return "list";
	}
	
	
	// http://localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		String sId = request.getParameter("id");
		
		model.addAttribute("dto",dao.viewDao(sId));
		
		return "view";
	}
	
	// http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public String Delete(
			HttpServletRequest request
			) {
		
		dao.deleteDao(request.getParameter("id"));
		
		return "redirect:list";
	}
	
	
	
	
	
	

}
