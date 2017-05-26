package org.frame.common.utils;

public class Consumer extends Thread {

	//每次消费的产品数量  
	private int num;
	
	//所在放置的仓库
	private Storage storage;
	
	public Consumer(Storage storage){
		this.storage = storage;
	}
	
	//线程方法run
	public void run(){
		consume(num);
	}
	//调用仓库Storage的消费函数  
	public void consume(int num){
		storage.consume(num);
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
}
