package org.frame.common.designPatterns.TemplateMethod;

/**
 * 模版方法模式-
 * 
 * 一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 * @author cjshen
 * @time 2017-11-02
 */
public abstract class AbstractCalculator {
	
	//主方法, 实现对其他类的调用
	public int calculate(String exp,String opt){
		int[] arrayInt = split(exp, opt);
		
		return calculate(arrayInt[0],arrayInt[1]);
	}
	
	
	public int[] split(String exp,String opt){
		String[] array = exp.split(opt);
		int[] arrayInt = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
	
	//被子类重写的方法
	public abstract int calculate(int num1,int num2);
	

}
