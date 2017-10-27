package org.frame.common.designPatterns.adapter;

/**
 * 接口适配 测试类
 * @author cjshen
 *
 */
public class Wrapper2Test {
	
	public static void main(String[] args) {
		Sourceable source1 = new SourceSub1();
		
		Sourceable source2 = new SourceSub2();
		
		source1.method1();
		source2.method2();
	}

}
