package org.frame.common.designPatterns.interpreter;

/**
 * 解释器模式
 * Context类是一个上下文环境类，Plus和Minus分别是用来计算的实现
 * @author cjshen
 *
 */

public interface Expression {
	
	public int interpret(Context context);

}
