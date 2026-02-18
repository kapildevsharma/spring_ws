package com.interview.threadlocal;

public class Client {

	public static void main(String[] args) {
		
		ThreadLocal threadLocal = new ThreadLocal();
		System.out.println(threadLocal.get());
		threadLocal.set("shankar1");
		System.out.println(threadLocal.get());
		threadLocal.remove();
		System.out.println(threadLocal.get());
		
		
		Thread thread1 = new Thread(new ThreadClass(), "Thread 1");
		Thread thread2 = new Thread(new ThreadClass(), "Thread 2");
		
		thread1.start();
		thread2.start();
	}
}
