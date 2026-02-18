package com.interview;

import java.util.HashMap;
import java.util.Map;

public class EClinicWorksR2Interview {
	public static void main(String[] args) {
		String str = "This is test";
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int s = 0; s<str.length();s++) {
			if(str.charAt(s) == ' ') {
				continue;
			}
			char c = Character.toLowerCase(str.charAt(s));
			if(charMap.containsKey(c)) {
				//means char already exists so lets increase count
				int currentCount = charMap.get(str.charAt(s));
				charMap.put(c, currentCount+1);
			}else {
				//lets add new char
				charMap.put(c, 1);
			}
		}
		
		System.out.println(charMap);
		
	}
}
