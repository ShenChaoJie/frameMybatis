package org.frame.common.designPatterns.interpreter;

public class Mins implements Expression {

	@Override
	public int interpret(Context context) {
		return context.getNum1()-context.getNum2();
	}

}
