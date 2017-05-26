package org.frame.common.utils;

import java.util.concurrent.BlockingQueue;

//生产者
public class ProducerQueue implements Runnable {
	
	//阻塞队列
	private final BlockingQueue<Object> proQueue;
	
	//传入对象
	private Object obj;

	public ProducerQueue(BlockingQueue<Object> proQueue,Object obj){
		this.proQueue = proQueue;
		this.obj = obj;
	}
	
	@Override
	public void run() {
		try {
			proQueue.put(obj);
			System.out.println("生产者生产的数字为 : " +obj+" ,队列长度:"+proQueue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public BlockingQueue<Object> getProQueue() {
		return proQueue;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	

}
