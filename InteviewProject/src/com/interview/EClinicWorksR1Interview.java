package com.interview;

public class EClinicWorksR1Interview {
	public static void main(String[] args) {
		
		int a[] = new int[]{10,15,13,1,7,20};
		int max = 0;
		String pair = "";
		for(int i=0;i<a.length-1;i++) {
			int calculatedSum = a[i]+a[i+1];
			if(max<calculatedSum) {
				max = calculatedSum;
				pair = a[i]+","+a[i+1];
			}
			
		}
		
		System.out.println(pair);
		
	}
}
