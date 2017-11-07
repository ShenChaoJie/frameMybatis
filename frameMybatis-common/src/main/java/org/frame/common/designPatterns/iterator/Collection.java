package org.frame.common.designPatterns.iterator;

public interface Collection {
	
	public Iterator iterator();
	
	/**
	 * 获取集合元素
	 * @param i
	 * @return
	 */
	public Object get(int i);
	
	
	/**
	 * 获取集合大小
	 * @return
	 */
	public int size();

}
