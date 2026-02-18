package com.interview.abstraction;

public interface MyInterface extends MyInterfaceTwo {
	
	public void makePayment();

	public default void show() {
		System.out.println("MyInterface default show method.");
	}
}
