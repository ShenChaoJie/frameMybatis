package org.frame.common.designPatterns.adapter;

/**
 * 接口适配 实现类2
 * @author cjshen
 *
 */
public class SourceSub2 extends Wrapper2 {
	
	@Override
	public void method2(){
		System.out.println("The sourceable interface's method2()");
	}

}
