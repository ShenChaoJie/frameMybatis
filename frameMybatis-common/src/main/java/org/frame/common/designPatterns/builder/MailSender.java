package org.frame.common.designPatterns.builder;

public class MailSender implements Sender {

	public MailSender(){
		System.out.println("init mailSender");
	}
	
	@Override
	public void send() {
		System.out.println("this is mailSender!");
	}

}
