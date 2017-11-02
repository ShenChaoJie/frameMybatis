package org.frame.common.designPatterns.facade;

/**
 * 外观模式  (没有涉及 接口)
 * 将类和类之间的关系 放在一起
 * @author cjshen
 *
 */
public class Computer {
	
	private CPU cpu;
	
	private Memory memory;
	
	private Disk disk;
	
	
	public Computer(){
		cpu = new CPU();
		memory  = new Memory();
		disk = new Disk();
	}
	
	
	public void startup(){
		System.out.println("start the computer!");
		
		cpu.startup();
		memory.startup();
		disk.startup();
		
		System.out.println("start computer finished!");
		
	}
	
	
	public void shutdown(){
		System.out.println("begin to close computer!");
		
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		
		System.out.println("computer closed");
		
		
	}
	

}
