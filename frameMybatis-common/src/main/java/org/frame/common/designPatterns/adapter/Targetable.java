package org.frame.common.designPatterns.adapter;

/**
 * 目标接口
 * @author cjshen
 *
 */
public interface Targetable {
	
	/**
	 * 与原始类中的方法相同
	 */
	public void method1();
	
	/**
	 * 新方法
	 */
	public void method2();

}
