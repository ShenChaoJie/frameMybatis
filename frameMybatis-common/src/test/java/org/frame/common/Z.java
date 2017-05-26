package org.frame.common;

class Z extends X{
	//Y y = new Y();
	
	public Z(){
		this.y = new Y();
		System.out.print("z");
	}
	
	public static void main(String[] args) {
		new Z();
	}
	
	
}

class X{
	Y y = new Y();
	public X(){
		System.out.print("x");
	}
}


class Y{
	public Y(){
		System.out.print("y");
	}
}
