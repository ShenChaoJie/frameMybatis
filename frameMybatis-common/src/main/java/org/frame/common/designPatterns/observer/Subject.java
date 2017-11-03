package org.frame.common.designPatterns.observer;


/**
 * 观察者模式
 * 当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系
 * @author cjshen
 *
 */
public interface Subject {
	
	/**
	 * 增加观察者
	 * @param observer
	 */
	public void add(Observer observer);
	
	
	/**
	 * 删除观察者
	 * @param observer
	 */
	public void delete(Observer observer);
	
	
	/**
	 * 通知所有的观察者
	 */
	public void notifyObserver();
	
	
	/**
	 * 自身操作
	 */
	public void operation();
	

}
