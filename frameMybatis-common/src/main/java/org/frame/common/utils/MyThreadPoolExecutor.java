package org.frame.common.utils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class MyThreadPoolExecutor {
	
	private static final BlockingQueue<Runnable> sendQueue = new LinkedBlockingQueue<Runnable>();
	
	
	/*  public static void execute(Runnable task) {  
	        synchronized (sendQueue) {  
	        	sendQueue.add(task);  
	        	sendQueue.notify();  
	        }  
	    }  */
	
	
	static class Task implements Runnable{
		
		//private MyThreadPool myThreadPool;
		private Object obj;
		
		public Task(){
			super();
		}
		public Task(Object obj) {
			super();
			this.obj = obj;
			//this.myThreadPool = myThreadPool;
		}

		@Override
		public void run() {
			while(true){
				try {
					this.sendCpThirdPayNotify(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
				sendQueue.remove(obj);
			}
		}
		
		public void sendCpThirdPayNotify(Object obj) throws Exception {
			System.out.println("数据-"+ obj.toString() +" 处理中...");
			//Thread.sleep(5000);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Object data = new Object();
		data = "ABC001";
		//execute(new Task(data));
		
		/*ThreadPoolExecutor threadPool = new  ThreadPoolExecutor(5, 10, 2*60*100, TimeUnit.HOURS,sendQueue);
		
		threadPool.execute(new Task(data));
		
		threadPool.shutdownNow();
		*/
		/*for(int i=1;i<10;i++){
			threadPool.execute(new Task(new MyThreadPool(),i));
		}*/
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.submit(new Task("AAA"));
		
		pool.submit(new Task("BBB"));
		
		
		
		
	}
	
	
	
}
