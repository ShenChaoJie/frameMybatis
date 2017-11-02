package org.frame.common.designPatterns.prototype;

import java.io.IOException;

public class prototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Prototype pro = new Prototype();
		
		Prototype pro1 = (Prototype) pro.clone();
		
		Prototype pro2 = (Prototype) pro.deepClone();
		
		System.out.println("浅复制对象比较:pro ---- pro1:"+pro.equals(pro1));
		
		System.out.println("深复制对象比较:pro ---- pro2:"+pro.equals(pro2));
		
		
		System.out.println("浅复制String比较:"+pro.getStr().equals(pro1.getStr()));
		
		
		System.out.println("浅复制Object比较:"+ pro.getObj().equals(pro1.getObj()) );
		
		
		
		System.out.println("深复制String比较:"+pro.getStr().equals(pro2.getStr()));
		
		
		System.out.println("深复制Object比较:"+ pro.getObj().equals(pro2.getObj()) );
		
	}
}
