package org.frame.common.designPatterns.adapter;

/**
 * 接口适配  实现类1
 * @author cjshen
 *
 */
public class SourceSub1 extends Wrapper2 {
	
	@Override
	public void method1(){
		System.out.println("The sourceable interface's method1()");
	}

}
