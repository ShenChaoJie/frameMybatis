package org.frame.common.designPatterns.command;

/**
 * 命令模式
 * Invoker是调用者，Receiver是被调用者，MyCommand是命令, 实现了Command接口，持有接收对象  
 * @author cjshen
 *
 */
public class MyCommand implements Command {
	
	private Receiver receiver;
	
	
	public MyCommand(Receiver receiver){
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		receiver.action();
	}

}
