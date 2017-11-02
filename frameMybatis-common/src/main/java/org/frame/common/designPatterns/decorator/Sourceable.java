package org.frame.common.designPatterns.decorator;

public interface Sourceable {
	
	public void method();

	public default void defaultMethod(){
		System.out.println("this is interface default method");
	}
}
