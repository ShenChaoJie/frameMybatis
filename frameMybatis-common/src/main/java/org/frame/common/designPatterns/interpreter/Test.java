package org.frame.common.designPatterns.interpreter;

public class Test {

	public static void main(String[] args) {
		Context context = new Context(3, 2);
		
		Expression exp = new Plus();
		
		System.out.println("结果:"+exp.interpret(context));
	}
}
