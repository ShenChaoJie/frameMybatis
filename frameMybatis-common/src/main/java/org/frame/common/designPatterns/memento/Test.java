package org.frame.common.designPatterns.memento;

public class Test {

	public static void main(String[] args) {
		
		//创建原始类
		Original origi = new Original("egg");
		
		//创建备忘录
		Storage storage = new Storage(origi.createMemento());
		
		//修改原始的状态
		System.out.println("初始化状态:"+origi.getValue());
		origi.setValue("niu");
		System.out.println("修改后状态:"+origi.getValue());
		
		
		//恢复原始状态
		origi.restoreMemento(storage.getMemento());
		System.out.println("恢复后状态:"+origi.getValue());
		
		
	}
	
}
