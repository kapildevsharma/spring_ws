package com.interview.threadlocal;

class CustomeThread implements Runnable{
	static Integer custId = 0;
	private static ThreadLocal t1 = new ThreadLocal() {
		@Override
		protected Integer initialValue() {
			return ++custId;
		}
	};
	
	@Override
	public void run() {
		System.out.println("ThreadName:"+Thread.currentThread().getName()+" and CustId:"+t1.get());
	}
}