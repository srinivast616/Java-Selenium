package com.java.programs;


public class ThreadExample {
	
	public static void main(String[] args)
	{

	        // Create thread using Runnable interface
	        Runnable task1 = new PrintTask("Thread-1");
	        Runnable task2 = new PrintTask("Thread-2");
	        Runnable task3 = new PrintTask("Thread-3");

	        // Create and start threads
	        Thread t1 = new Thread(task1);
	        Thread t2 = new Thread(task2);
	        Thread t3 = new Thread(task3);

	        t1.start();
	        t2.start();
	        t3.start();
	    }
	}

	// Runnable class to define task
	class PrintTask implements Runnable {
	    private String threadName;

	    public PrintTask(String name) {
	        this.threadName = name;
	    }

	    @Override
	    public void run() {
	        // Each thread prints 5 messages
	        for (int i = 1; i <= 5; i++) {
	            System.out.println(threadName + " - Count: " + i);
	            try {
	                Thread.sleep(500); // Sleep to simulate work
	            } catch (InterruptedException e) {
	                System.out.println(threadName + " interrupted.");
	            }
	        }
	        System.out.println(threadName + " finished.");
	    }

}
