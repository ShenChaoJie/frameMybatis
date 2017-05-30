package org.frame.common;

public class Cat {
	public Cat(){
		System.out.println("I am a cat!");
	}
	public static void main(String[] args) {
		Cat cat = new Cat();
	}
}


abstract class Animal{
	abstract void say();
}