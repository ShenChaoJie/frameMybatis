package org.frame.common;


class People {
	
	String name;
	
	public People(){
		System.out.println(1);
	}
	
	public People(String name){
		System.out.println(2);
		this.name = name;
		//System.out.println(name);
	}
	
	public static void main(String[] args) {
		People child  = new  Child("mike");// 结果  132
		People child2  = new  Child();// 结果  14
	}
	
}

class Child extends People {
	
	People father;
	
	public Child(String name){
		System.out.println(3);
		this.name = name;
		father = new People(name+":F");
	}
	
	public Child(){
		System.out.println(4);
	}
}

