package com.interview.abstraction;

public class MySubAbstract extends MyAbstractParent{
	public void test() {
		System.out.println("Testing this child class");
	}
	
	public static void main(String[] args) {
		MyAbstractParent parent = new MyAbstractParent();
		MySubAbstract child = new MySubAbstract();
		parent =child;
		parent.test();
		child.test();
		
	}
}
