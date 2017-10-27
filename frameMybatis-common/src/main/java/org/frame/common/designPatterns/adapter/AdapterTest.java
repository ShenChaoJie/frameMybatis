package org.frame.common.designPatterns.adapter;

/**
 * 类适配模式 测试类
 * @author cjshen
 *
 */
public class AdapterTest {
	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
		
	}

}
