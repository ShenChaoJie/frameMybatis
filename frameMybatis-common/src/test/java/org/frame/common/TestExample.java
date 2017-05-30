package org.frame.common;

public class TestExample {
	 String str = new String("good");
	 char[] ch = {'a','b','c'};
	 public static void main(String[] args) {
		 TestExample ex = new TestExample();
		 ex.change(ex.str, ex.ch);
		 System.out.print(ex.str+ " and ");
		 System.out.println(ex.ch);
	}
	 public void change(String str,char ch[]){
		 str = "test ok";
		 ch[0] = 'g';
	 }
	 
	 
}
