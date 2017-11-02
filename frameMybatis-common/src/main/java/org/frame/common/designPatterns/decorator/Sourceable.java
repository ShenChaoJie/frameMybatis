package org.frame.common.designPatterns.decorator;

public interface Sourceable {
	
	public void method();

	/*
	 * JDK 1.8 新特性 
	 */
	public default void defaultMethod(){
		System.out.println("this is interface default method");
	}
}
