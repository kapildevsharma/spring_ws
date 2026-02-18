package com.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AccoliteRound1Interview {
	public static void main(String[] args) {
				
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(9);
		list.add(2);
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		ListIterator<Integer> iterator = list.listIterator(list.size());
		System.out.println(iterator.hasPrevious());
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
		
	}
	
	
}