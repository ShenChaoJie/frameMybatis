package org.frame.common.designPatterns.java8;

public interface Formula {

	double calculate(int a);
	
	/**
	 * 接口中  default修饰 的方法, 可以有方法体
	 * @param a
	 * @return
	 */
	default double sqrt(int a){
		return Math.sqrt(a);//平方根
	}
	
}
