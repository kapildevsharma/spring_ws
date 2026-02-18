package com.interview.threadlocal;

public class ThreadLocalDemo{
	public static void main(String[] args) {
		CustomeThread ct1 = new CustomeThread();
		CustomeThread ct2 = new CustomeThread();
		CustomeThread ct3 = new CustomeThread();
		
		Thread thread1 = new Thread(ct1,"Customer 1");
		Thread thread2 = new Thread(ct2,"Customer 2");
		Thread thread3 = new Thread(ct3,"Customer 3");
		try {
			thread1.join();
		}catch(Exception ex) {}
		thread1.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread2.start();
		thread3.start();
		
	}
}