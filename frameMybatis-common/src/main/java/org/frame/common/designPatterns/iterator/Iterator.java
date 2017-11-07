package org.frame.common.designPatterns.iterator;


/**
 * 迭代子模式
 * @author cjshen
 *
 */
public interface Iterator {
	
	/**
	 * 前移
	 * @return
	 */
	public Object previous();
	
	
	/**
	 * 后移
	 * @return
	 */
	public Object next();
	
	
	/**
	 * 是否有下一个
	 * @return
	 */
	public boolean hasNext();
	
	
	/**
	 * 获取第一个元素
	 * @return
	 */
	public Object first();

}
