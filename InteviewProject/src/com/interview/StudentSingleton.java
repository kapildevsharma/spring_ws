package com.interview;

public class StudentSingleton {
	
	private static StudentSingleton studentSingleton;
	
	private StudentSingleton() {
		if(studentSingleton!=null) {
			//prevent from breaking singleton logic
			throw new RuntimeException("You are trying to break singleton object");
		}
	}
	
	public static StudentSingleton getInstance() {
		if(studentSingleton == null) {
			synchronized (StudentSingleton.class) {
				if(studentSingleton == null) {
					studentSingleton = new StudentSingleton();
				}
			}
		}
		
		return studentSingleton;
	}
}
