package com.interview;

import java.lang.reflect.Constructor;

public class BreakSingleton {
	public static void main(String[] args) {
		try {
			StudentSingleton s1 = StudentSingleton.getInstance();
			System.out.println("Hash Code for s1:"+s1.hashCode());
			
			//Reflection API to break singleton logic
			Constructor<StudentSingleton> constructor = StudentSingleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			StudentSingleton s2 = constructor.newInstance();
			System.out.println("Hash Code for s2:"+s2.hashCode());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
