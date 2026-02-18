package com.interview.abstraction;

public class MyClass implements MyInterface{
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.show();
		myClass.makePayment();
	}

	@Override
	public void makePayment() {
		System.out.println("Payment started");
	}
}
