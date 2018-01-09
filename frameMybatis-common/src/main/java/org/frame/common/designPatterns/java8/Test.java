package org.frame.common.designPatterns.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;



import org.apache.commons.lang.builder.CompareToBuilder;
import org.springframework.core.convert.converter.Converter;

public class Test {
	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
		};
		
		//System.out.println(formula.calculate(100));
		
		//接口中的default修饰的方法, 都是可以使用的
		//System.out.println(formula.sqrt(10));
		
		
		
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		names.forEach(o -> {System.out.println(o);});
		
		System.out.println("--------------------");
		names.forEach(new Consumer<String>() {

			@Override
			public void accept(String  t) {
				System.out.println(t);
				
			}
		});
		
		
		
		Collections.sort(names,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		Collections.sort(names,(a,b)->b.compareTo(a));
		
		Runnable r1 = () -> {System.out.println("abx");};
		
		
		
		Formula formula2 = (a)-> Math.random()*a; 
		
		System.out.println(formula2.calculate(10)+"----"+formula2.sqrt(9));
		
		/*InterfaceTest itest = new InterfaceTest() {
			
			@Override
			public int method(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void method(String str, String str2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void method(String str) {
				// TODO Auto-generated method stub
				
			}
		};*/
		
		
		InterfaceTest itest2 = (str1,str2)->{return str1+str2;};
		
		
		System.out.println(itest2.method2("123", "abc"));
		
		//抽象类是无法使用 lambda表达式
		//AbstractTest aTest1 = (str)->{System.out.println(str);};
		
		
		
		/*Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		Thread thread =new Thread(()->{System.out.println("runnable");});
		
		
		int num = 1;
		
		Converter<String, Integer> a = (from) -> {
			return Integer.valueOf(num+from);
		};
		System.out.println(a.convert("2"));
		
		Converter<String, Integer> converter = Integer::valueOf;
		
		
		
	}
}
