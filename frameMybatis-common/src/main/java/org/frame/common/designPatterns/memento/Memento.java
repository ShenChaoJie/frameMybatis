package org.frame.common.designPatterns.memento;


/**
 * 备忘录模式
 * 保存一个对象的某个状态，以便在适当的时候恢复对象
 * @author cjshen
 *
 */
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
