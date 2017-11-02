package org.frame.common.designPatterns.builder;

public class SmsSender implements Sender {

	public SmsSender(){
		System.out.println("init smsSender");
	}
	
	@Override
	public void send() {
		System.out.println("this is smsSender!");
	}

}
