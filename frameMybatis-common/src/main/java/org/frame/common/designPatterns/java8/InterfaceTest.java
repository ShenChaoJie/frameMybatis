package org.frame.common.designPatterns.java8;

public interface InterfaceTest {

	//void method1(String str);
	
	String method2(String str,String str2);
	
	//int method3(int a,int b);
	
	default int defaultMethod(int a,int b){
		return a+b;
	}
}
