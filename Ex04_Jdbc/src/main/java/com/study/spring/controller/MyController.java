package com.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@Autowired
	MyDAO listDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "jdbc template";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("lists", listDao.list());
		return "index";
	}
}
