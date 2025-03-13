package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
//	1. spring starter project(Ex03_Web_test)
//	2.  jsp설정( build.gradle, application.properties) / gradle수정시 refresh해야함
//	3. 폴더생성 main/webapp/WEB-INF/views
//	4. jsp 파일생성
//	5. controller.java 작성(jsp mapping)
//	6. form, action
	
	//http://192.168.0.94:8080
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "model";
	}
	
	// localhost:8080/index?name=이순신&id=lee&jumin=201115-102020
	@RequestMapping("/index")
	public String index(
			HttpServletRequest httpServletRequest,
			Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		String jumin = httpServletRequest.getParameter("jumin");
		
//		model.addAttribute("name", "홍길동");
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("jumin",jumin);
		return "index";
	}
	
	// http://localhost:8080/test1?name=이순신&id=lee&jumin&
	@RequestMapping("/test1")
	public String test1(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("jumin") String jumin,
			Model model
			) {
		
		model.addAttribute("id",id);
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		return "test1"; // jsp
	}
	
	// http://localhost:8080/test2?name=이순신&id=lee
	@RequestMapping("/test2")
	public String test2(Member member,Model model) {
		return "test2";
	}
	
	
	// http://localhost:8080/test3/{studentId}/{name}
	@RequestMapping("/test3/{studentId}/{name}")
	public String test3(
			@PathVariable("studentId") String studentId,
			@PathVariable("name") String name,
			Model model
			) {
		
		model.addAttribute("studentId", studentId);
		model.addAttribute("name", name);
		return "test3";
	}
	
	
//	public String test4(
//			@PathVariable Member member, Model model
//			) {
//		model.addAttribute("studentId", member.getId());
//		return "test4";
//	}
	
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	


}
