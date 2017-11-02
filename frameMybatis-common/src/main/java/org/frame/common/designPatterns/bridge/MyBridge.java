package org.frame.common.designPatterns.bridge;

public class MyBridge extends Bridge {
	
	@Override
	public void method(){
		getSource().method();
	}

}
