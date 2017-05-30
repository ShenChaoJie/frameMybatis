package org.frame.common;

public class TestDemo {
	private int count;
	
	public TestDemo(int a){
		count = a;
	}
	
	public static void main(String[] args) {
		TestDemo testDemo = new TestDemo(88);
		
		System.out.println(testDemo.count);
	}
	
}
