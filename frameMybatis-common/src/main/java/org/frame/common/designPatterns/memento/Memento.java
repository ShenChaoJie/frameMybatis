package org.frame.common.designPatterns.memento;

public class Memento {
	
	private String value;
	
	public Memento(String value){
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
