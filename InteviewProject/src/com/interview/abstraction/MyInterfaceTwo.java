package com.interview.abstraction;

public interface MyInterfaceTwo {
	
	public void makePayment();
	
	public default void show() {
		System.out.println("MyInterface2 default show method.");
	}

}
