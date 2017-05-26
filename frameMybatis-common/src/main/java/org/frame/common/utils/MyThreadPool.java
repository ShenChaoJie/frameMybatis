package org.frame.common.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.threadpool.ThreadPool;
import com.alibaba.dubbo.common.threadpool.support.cached.CachedThreadPool;

public class MyThreadPool  {
	
	private static final BlockingQueue<Object> sendQueue = new LinkedBlockingQueue<Object>();

	// 任务类  
    static class Task implements Runnable {  
        private static volatile int i = 1;  
  
        @Override  
        public void run() {// 执行任务  
        	try {
        		while(true){
        			Object obj = sendQueue.take();
        			String str = (String)obj;
        			System.out.println(Thread.currentThread().getName()+"--数据:"+str+"处理中...");
        			
        			 //int threadSize = sendQueue.size();
        			 //System.out.println("线程队列大小-->"+threadSize); 
        		}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //System.out.println("任务 " + (i++) + " 完成");  
        }  
    }  
    
    public static void addQueue(Object obj) throws InterruptedException{
    	sendQueue.put(obj);
    }
    
    public static void main(String[] args) throws InterruptedException {  
       /* // 创建3个线程的线程池  
        ThreadPool t = ThreadPool.getThreadPool(5);  
        t.execute(new Runnable[] { new Task(), new Task(), new Task() });  
        t.execute(new Runnable[] { new Task(), new Task(), new Task() });  
        System.out.println("--"+t);  
        t.destroy();// 所有线程都执行完成才destory  
        System.out.println("--"+t);  */
    	
    	ThreadPool t = new CachedThreadPool();
    	Executor executor= t.getExecutor(new URL("Test_protocal","Test_host",5));
    	
    	 for(int i=1;i<=20;i++){
    		 String obj = "Test_obj_"+i;
    		 addQueue(obj);
    	 }
    	 //executor.execute(new Task());
    	 //int threadSize = sendQueue.size();
		// System.out.println("线程队列大小-->"+threadSize); 
    	 
    	 for(int i=1;i<=20;i++){
    		 executor.execute(new Task());
    		 int threadSize = sendQueue.size();
    		 System.out.println("线程队列大小-->"+threadSize); 
    	 }
    	 
    }
	
}
