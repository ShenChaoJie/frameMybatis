package org.frame.common.designPatterns.singleton;

/**
 * 使用一个内部类 来维护 单例模式
 * @author cjshen
 *
 */
public class Singleton3 {

	//私有构造方法,防止被实例化
	private Singleton3(){
		
	}
	
	//使用内部类维护单例
	/*JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
	这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕*/
	private static class SingletonFactory{
		private static Singleton3 instance = new Singleton3();
	}

	//获取示例
	public static Singleton3 getInstance(){
		return SingletonFactory.instance;
	}
	
	//如果该对象被用于序列化，可以保证对象在序列化前后保持一致 
	public Object readResolve(){
		return getInstance();
	}
	
}
