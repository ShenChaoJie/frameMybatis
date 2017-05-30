package org.frame.common.utils;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable {

	//阻塞队列
	private final BlockingQueue<Object> conQueue;
	
	public ConsumerQueue(BlockingQueue<Object> conQueue){
		this.conQueue = conQueue;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("消费者消费数字为 ："+conQueue.take()+" ,队列长度为:"+conQueue.size());;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public BlockingQueue<Object> getConQueue() {
		return conQueue;
	}

}
