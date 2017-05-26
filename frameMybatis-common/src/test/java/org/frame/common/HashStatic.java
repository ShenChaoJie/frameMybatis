package org.frame.common;

public class HashStatic {
	private static int x=100;
	
	public static void main(String[] args) {
		HashStatic hs1 = new HashStatic(); 
		hs1.x++;//101
		HashStatic hs2 = new HashStatic(); 
		hs2.x++;//102
		hs1 = new HashStatic(); 
		hs1.x++;//103
		
		HashStatic.x--;//102
		System.out.println("x="+x);//102
	}
}
