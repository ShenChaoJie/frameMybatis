package org.frame.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		//executor.submit(task);
		//executor.execute(command);
	}
	
}
