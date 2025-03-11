package com.study.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@Autowired
	Member member1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printer;
	
	@Autowired
	Member member2;
	
	
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		member1.print();
		member1.setPrinter(printer);
		member1.setName("홍길동");
		member1.setNickname("빅도사");
		member1.print();
		
		
		return "spring boot" ;
	}
	
	@RequestMapping("/test")
	public @ResponseBody String test() {
		
		member2.print();
		return "test view";
	}
}
