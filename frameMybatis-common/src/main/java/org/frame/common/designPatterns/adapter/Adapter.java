package org.frame.common.designPatterns.adapter;


/**
 * 类适配模式
 * @author cjshen
 *
 */
public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		 System.out.println("this is the targetable method!");  
	}

}
