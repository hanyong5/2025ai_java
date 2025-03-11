package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.spring.bean.BeanContainer;
import com.study.spring.tv.LgTv;
import com.study.spring.tv.SonyTv;
import com.study.spring.tv.TV;



//@SpringBootApplication
public class Ex01IoCApplication {
	static BeanContainer container = new BeanContainer();

	public static void main(String[] args) {
//		SpringApplication.run(Ex01IoCApplication.class, args);
		
//		TV tv = new SonyTv();
		
		TV tv = (TV)container.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}

}
