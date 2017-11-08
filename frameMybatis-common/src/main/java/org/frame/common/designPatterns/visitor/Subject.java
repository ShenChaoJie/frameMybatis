package org.frame.common.designPatterns.visitor;

public interface Subject {
	
	public void accept(Visitor visitor);
	
	public String getSubject();

}
