package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "model";
	}
	
	// localhost:8080/index?name=이순신&id=100
	@RequestMapping("/index")
	public String index(
			HttpServletRequest httpServletRequest,
			Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		
//		model.addAttribute("name", "홍길동");
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		return "index";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	
}
