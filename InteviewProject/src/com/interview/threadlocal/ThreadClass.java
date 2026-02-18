package com.interview.threadlocal;

public class ThreadClass implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i<=3;i++) {
			System.out.println("Thread Name"+Thread.currentThread().getName()+" Current Date:"+DateUtils.getDate("yyyy/mm/dd"));
		}
	}

}
