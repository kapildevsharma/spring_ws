package com.interview;

import java.util.concurrent.Callable;

class PrintNumber implements Runnable, Callable {
	int filterType;
	public void run() {
		for(int i = 1; i<=10;i++) {
			if(getFilterType() == 1) { //Even
				if(i%2 == 0) {
					System.out.println(i);
				}
			}else {
				if(i%2 == 1) {
					System.out.println(i);
				}
			}
		}
	}
	/**
	 * @return the filterType
	 */
	public int getFilterType() {
		return filterType;
	}
	/**
	 * @param filterType the filterType to set
	 */
	public void setFilterType(int filterType) {
		this.filterType = filterType;
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class InterviewRound {
	public static void main(String[] args) {
		
		PrintNumber pn1 = new PrintNumber();
		pn1.setFilterType(1);
		
		PrintNumber pn2 = new PrintNumber();
		
		Thread thread1 = new Thread(pn1);
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread thread2 = new Thread(pn2);
		thread2.start();
		
		Runnable task1 = () -> {
			for(int i = 1; i <=10;i++) {
				if(i%2 == 0) {
					System.out.println(i);
				}
			}
		};
		
		Runnable task2 = () -> {
			for(int i = 1; i <=10;i++) {
				if(i%2 == 1) {
					System.out.println(i);
				}
			}
		};
		
		Thread thread3 = new Thread(task1);
		Thread thread4 = new Thread(task2);
		thread3.start();
		thread4.start();
		
	}
	
}