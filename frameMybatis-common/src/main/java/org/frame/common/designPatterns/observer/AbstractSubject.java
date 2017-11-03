package org.frame.common.designPatterns.observer;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {
	
	private Vector<Observer> vector = new Vector<Observer>();

	@Override
	public void add(Observer observer) {
		vector.add(observer);

	}

	@Override
	public void delete(Observer observer) {
		vector.remove(observer);

	}

	@Override
	public void notifyObserver() {
		Enumeration<Observer> enumo  =  vector.elements();
		while(enumo.hasMoreElements()){
			enumo.nextElement().update();
		}

	}

	/*@Override
	public void operation() {
		// TODO Auto-generated method stub

	}*/

}
