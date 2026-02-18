package com.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class EPAMInterview {
	public static void main(String[] args) {
		
		String str = "KOL-BOM,BOM-DEL,HYD-KOL";
		List<String> tickets = Arrays.asList(str.split(","));// [KOL-BOM,BOM-DEL, HYD-DEL]
		//Output: HYD-KOL, KOL-BOM, BOM-DEL
		HashMap<String, String> fromTo = new HashMap<String, String>();
		HashMap<String, String> toFrom = new HashMap<String, String>();
		for(String ticket: tickets) {
			String from = ticket.split("-")[0];
			String to = ticket.split("-")[1];
			fromTo.put(from, to);
			//toFrom.put(to, from);
		}
		
		String start = "";
		Set<String> fromtoSet = fromTo.keySet();
		for(String key: fromtoSet) {
			if(!toFrom.containsKey(key)) {
				start = key;
				break;
			}
		}
		System.out.println(start);
		
		while(true) {
			
		}
		
	}
}
