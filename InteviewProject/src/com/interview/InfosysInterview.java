package com.interview;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class InfosysInterview {

	public static void main(String[] args) {
		char c = 'a';
		StringBuilder sb = new StringBuilder("java");
		for(int i = 0; i<sb.length();i++) {
			if(sb.charAt(i) == c) {
				sb.deleteCharAt(i);
			}
		}
		System.out.println("Remove char in string : "+ sb.toString());
		
		// Find Kth smallest elements from unsorted array
		int a[] = new int[]{3,2,1,5,6,4};
		int k = 2;
		System.out.println("findKthSmallestElement : "+findKthSmallestElement(a,k));
		
		a = new int[]{3,2,3,1,2,4,5,5,6};
		k = 4;
		System.out.println("findKthLargestElement : "+findKthLargestElement(a,k));
		
	}
	public static Integer findKthLargestElement(int nums[], int k) {
		// Min-heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Iterate through the array
        for (int num : nums) {
            minHeap.offer(num);  // Add the current element to the heap

            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // The root of the heap is the kth largest element
        return minHeap.peek();
		
	}
	
	public static Integer findKthSmallestElement(int a[], int k) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0;i<a.length;i++) {
			set.add(a[i]);
		}
		
		Iterator<Integer> itr = set.iterator();
		int count = 1;
		while(itr.hasNext()) {
			if(count == k) {
				return itr.next();
			}
			itr.next();
			count++;
		}
		return null;
	}
}
