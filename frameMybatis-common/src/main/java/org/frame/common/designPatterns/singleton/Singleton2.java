package org.frame.common.designPatterns.singleton;

/**
 * 静态方法实现单例模式
 * @author cjshen
 *
 */
public class Singleton2 {
	
	//静态变量 只加载一次
	private static final Singleton2 single = new Singleton2();

	private Singleton2() {
		
	}
	public static final Singleton2 getInstance(){
		return single;
	}
	

}
