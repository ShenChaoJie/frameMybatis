package org.frame.common.designPatterns.decorator;

/**
 * 装饰器模式
 * @author cjshen
 *
 */
public class Decorator implements Sourceable {
	
	private Sourceable source;
	
	public Decorator(Sourceable source){
		super();
		this.source = source;
	}
	

	@Override
	public void method() {
		
		System.out.println("---before decorator!");
		
		source.defaultMethod();
		source.method();
		
		System.out.println("---after decorator!");
	}

}
