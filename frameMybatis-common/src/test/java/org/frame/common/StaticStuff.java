package org.frame.common;

public class StaticStuff {
	static int x=10;
	//static int y=15;
	static {x+=10;}
	//static {y=y+5;}
	public static void main(String args[]){
		System.out.println("x="+x);
		//System.out.println("y="+y);
	}
	static {x/=3;}

}
