package com.study.spring.tv;

public class LgTv implements TV {
	
	public LgTv() {
		System.out.println("LgTv 생성");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTv 전원을 껸다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTv 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LgTv 소리를 껸다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTv 소리를 끈다.");
	}

}
