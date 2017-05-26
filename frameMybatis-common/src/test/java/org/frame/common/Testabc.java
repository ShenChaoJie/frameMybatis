package org.frame.common;

public class Testabc {

	public static int getVlaue(int i){
		int result = 1;
		switch(i){
		  case 1:
		  	result++;
		  case 2:
			result++;
		  case 3:
			result++;
		  case 4:
			result++;
		  case 5:
			result++;
		  default:
			result++;
		}
		return result+i;
	}
	
	public static void main(String[] args) {
		System.out.println(getVlaue(4));
	}
}
