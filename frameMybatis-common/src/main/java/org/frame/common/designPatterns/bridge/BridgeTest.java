package org.frame.common.designPatterns.bridge;

public class BridgeTest {
	public static void main(String[] args) {
		Bridge bridge = new MyBridge();
		
		Sourceable source = new SourceSub2();
		bridge.setSource(source);
		
		bridge.method();
	}

}
