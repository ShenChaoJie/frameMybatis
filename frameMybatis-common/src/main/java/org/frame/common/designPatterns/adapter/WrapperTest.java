package org.frame.common.designPatterns.adapter;

/**
 * 对象适配模式 测试类
 * @author cjshen
 *
 */
public class WrapperTest {
	public static void main(String[] args) {
		
		Targetable target = new Wrapper(new Source());
		target.method1();
		target.method2();
		
	}
}
