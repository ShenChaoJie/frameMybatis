package org.frame.common.designPatterns.TemplateMethod;

public class TemplateMethodTest {
	public static void main(String[] args) {
		AbstractCalculator cal = new Plus();
		
		int result = cal.calculate("4+8", "\\+");
		
		System.out.println(result);
	}
}
