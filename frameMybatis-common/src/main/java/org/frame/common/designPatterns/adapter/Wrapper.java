package org.frame.common.designPatterns.adapter;

/**
 * 对象适配模式
 * @author cjshen
 *
 */
public class Wrapper implements Targetable {
	
	private Source source;
	
	public Wrapper(Source source){
		this.source = source;
	}
	

	@Override
	public void method1() {
		source.method1();

	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!"); 
	}

}
