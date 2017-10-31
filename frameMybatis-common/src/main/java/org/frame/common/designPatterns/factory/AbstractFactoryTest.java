package org.frame.common.designPatterns.factory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		Provider provider  = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
	}
}
