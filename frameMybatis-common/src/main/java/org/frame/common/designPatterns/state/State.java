package org.frame.common.designPatterns.state;

/**
 * 状态模式
 * 1、可以通过改变状态来获得不同的行为。
 * 2、你的好友能同时看到你的变化。
 * @author cjshen
 *
 */
public class State {

	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void method1(){
		System.out.println("execute the first opt!");
	}
	
	public void method2(){
		System.out.println("execute the second opt!");
	}
	
}
