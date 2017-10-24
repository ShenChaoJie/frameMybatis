package org.frame.common.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {

	public static void main(String[] args) {
		//阻塞队列
		BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<Object>(50);
		int main=1;
		
		ExecutorService proPool = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<8;i++){
			proPool.submit(new ProducerQueue(blockingQueue, i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		proPool.shutdown();
		
		ExecutorService conPool = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			conPool.submit(new ConsumerQueue(blockingQueue));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		conPool.shutdown();
		
		
	}
}
