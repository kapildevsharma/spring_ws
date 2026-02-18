package com.interview;

public class BackbaseProblem2 {
	public static void main(String[] args) {
		int a[] = {3,2,1,5};
		System.out.println(solution(a));
	}
	
	public static int solution(int a[]) {
		if(a.length == 0) {
			return 0;
		}else if(a.length == 1) {
			return 1;
		}
		int moments = 0;
		int maxPosition = 0;
		for(int i = 0;i<a.length;i++) {
			maxPosition = Math.max(maxPosition, a[i]);
			if(maxPosition == (i+1)) {
				moments++;
			}
		}
		
		return moments;
	}
}
