package com.java.programs;

public class ThreadPriority extends Thread {
	
	public void run()
	{
		System.out.println("Active Thread Name = " + Thread.currentThread().getName());
		System.out.println("Active Thread Priority = " + Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		ThreadPriority tp1 = new ThreadPriority();
		ThreadPriority tp2 = new ThreadPriority();
		tp1.setPriority(Thread.MIN_PRIORITY);
		tp2.setPriority(Thread.MAX_PRIORITY);
		tp1.start();
		tp2.start();
	}
}
