package org.frame.common.designPatterns.strategy;

public class StrategyTest {

	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculator(exp);
		System.out.println(result);
	}
}
