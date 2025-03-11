package com.study.spring.tv;

public class SonyTv implements TV {
	
	public SonyTv() {
		System.out.println("SonyTv  생성");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("SonyTv  전원을 껸다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SonyTv  전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("SonyTv  소리를 껸다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("SonyTv  소리를 끈다.");
	}

}
