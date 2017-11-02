package org.frame.common.designPatterns.decorator;

public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("this is original method!");
	}

}
