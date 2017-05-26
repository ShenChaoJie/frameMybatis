//asad
package org.frame.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

public abstract class Testaaa {
	public int constInt = 5;

	// value = value + 5;

	public abstract void method(int a);

	// public abstract void anotherMethod(int a){};

	/*
	 * public int method(int a){ return 1; }
	 */

	public void method() {

	}

	public static void main(String[] args) {
		
		// map
		// SortedSet
		
/*		byte b = (byte)129;
		char c = 'a';
		String s = "str";
		int i = 12;
		
		double d = 0.55D;
		float f = 1.12F;
		switch (TestEnum.failed_noLog) {
		case "a":
			
			break;

		default:
			break;
		}
		*/
		
		/*for( int i = 4 ; i > 0 ; i-- ){
			int j = 0 ;
			do{
				j++;
				if( j == 2 ){
					break;
				}
			}while( j < i );
			System.out.print( j );// 2221
		}*/
		
		//Map map1 =  (Map) new Map().put("key" , "value") ;
		
		//Map map2 = (Map) new java.util.SortedMap().put("key" , "value") ;
		
		/*new java.util.Map().put("key" , "value") ;//X
		
		new java.util.SortedMap().put("key" , "value") ;//X
		
		new java.util.HashMap().put( null , null ) ;
		
		new java.util.TreeMap().put( 0 , null ) ;*/
		
		System.out.println(Math.random());
		System.out.println(new Random().nextInt(11));
		
		
	}
	
	public int aaa(int a){
		return 1;
	}
	
	public String aaa(String a){
		return "1";
	}
	
	

	public static void abc(int a) {
		System.out.println(a);
	}

	public void show(String x,int b,String... a){
		
	}
	public void show( String[] aa, String... a ){}
	
	
	
}
