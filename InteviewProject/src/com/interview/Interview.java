package com.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Interview {
	public static void main(String[] args) {
		
		/*int nums[] = new int[]{1,1,1,2,2,3,2,2,3,4,3,5,3,3,3};
		topKFrequent(nums, 3);*/
		//System.out.println(isAnagram("anagram", "nagaram"));
		//System.out.println(isPalindrome(-121));
		
		/*String strs[] = new String[]{"flower","f","floght"};
		System.out.println(longestCommonPrefix(strs));*/
		
		//System.out.println(romanToInt("LVIII"));
		
		//String str = " ";
		//System.out.println(checkPalindrome(str));
		
		//Reverse Integer
		//System.out.println(reverse(999999997));
		
		//char [] c = new char[] {'A','d','f'};
		//System.out.println(nextGreatestLetter(c, 'z'));
		
		//System.out.println(lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		Iterator<Integer> iterator =  list.iterator();
		while(iterator.hasNext()) {
			int num = iterator.next();
			if(num == 20) {
				iterator.remove();
			}
			System.out.println(num);
		}
		
		System.out.println(list);
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		String str = "";
        if(!s.isEmpty()) {
        	if(s.length() == 1) {
        		return 1;
        	}
        	
        	for(int i = 0; i<s.length();i++) {
        		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        		int currentCount = 0;
        		for(int j =i; j<s.length();j++) {
        			char c = s.charAt(j);
        			if(map.containsKey(c)) {
        				break;
        			}else {
        				currentCount = currentCount + 1;
        				map.put(c, currentCount);
        			}
        		}
        		if(currentCount>max) {
        			max = currentCount;
        			str = map.keySet()+"";
        			System.out.println(str);
        		}
        		
        	}
        	System.out.println("Length:=>"+max);
        	
        }
        	
        return max;
    }
	
	private static char nextGreatestLetter(char[] letters, char target) {
		if(letters[letters.length-1]>target) {
			for(int i=0;i<letters.length;i++) {
				if(letters[i]>target) {
					return letters[i];
				}
			}
		}
		
		return letters[0];
    }
	
	private static int reverse(int x) {
		int sum = 0;
		int prev_rev_num = 0 ;
		while(x!=0) {
			int t = x%10;
			x=x/10;
			sum = sum*10+t;
			if ((sum - t)/10 != prev_rev_num){
                return 0;
            }
			prev_rev_num = sum;
		}
		return sum;
    }
	
	private static boolean checkPalindrome(String s) {
        //lets get only alphanumeric characters only
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        if(s.isEmpty()) {
        	return true;
        }
        int right = s.length()-1;
        for(int i = 0; i<s.length();i++){
            if(i>=right){
                return true;
            }
            if(s.charAt(i) != s.charAt(right)){
                return false;
            }
            right--;
        }
        return false;
    }
	
	public static int romanToInt(String str) {
		int sum = 0;
		for(int i = 0;i<str.length(); i++) {
			int current = value(str.charAt(i));
			if(i+1>=str.length()) {
				sum = sum + current;
			}else {
				int next = value(str.charAt(i+1));
				if(current<next) {
					sum = sum - current;
				}else {
					sum = sum + current;
				}
			}
		}
		return sum;
	}
	
	private static int value(char r) 
	  { 
	    if (r == 'I') 
	      return 1; 
	    if (r == 'V') 
	      return 5; 
	    if (r == 'X') 
	      return 10; 
	    if (r == 'L') 
	      return 50; 
	    if (r == 'C') 
	      return 100; 
	    if (r == 'D') 
	      return 500; 
	    if (r == 'M') 
	      return 1000; 
	    return -1; 
	  } 
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		if(strs.length == 1) return strs[0];
		String longest = "";
		
		int i = 0;
		while(true) {
			boolean present = true;
			System.out.println(i);
			for(int j = 1;j<strs.length;j++) {
				System.out.print(strs[j].length()+" ");
				if(i>=strs[0].length() || i>=strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
					present = false;
					break;
				}
			}
			if(!present) {
				break;
			}else {
				longest = longest+strs[0].charAt(i);
			}
			i++;
			
			if(strs[0].length() <= i)
				break;
		}
		
		return longest;
		
	}
	
	public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if(str.length() == 1) return true;
        int left = 0; int right = str.length()-1;
        while(left<right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
	
	public static boolean isAnagram(String s, String t) {
        if(s.length()==t.length()){   
            char sArray[] = s.toCharArray();
            Arrays.sort(sArray);
            char tArray[] = t.toCharArray();
            Arrays.sort(tArray);
            if(new String(sArray).equals(new String(tArray))){
                return true;
            }
        }
        return false;
    }
	
	public static void topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i<nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		int count = map.get(nums[i])+1;
        		map.put(nums[i], count);
        	}else {
        		map.put(nums[i], 1);
        	}
        }
        System.out.println(map);
        
        Object[] a = map.entrySet().toArray();
        
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<Integer, Integer>) o2).getValue()
                           .compareTo(((Map.Entry<Integer, Integer>) o1).getValue());
            }
        });
        int count = 0;
        for (Object e : a) {
        	if(count==k) {
        		break;
        	}
            System.out.println(((Map.Entry<Integer, Integer>) e).getKey() + " : "
                    + ((Map.Entry<Integer, Integer>) e).getValue());
            count++;
        }
        
    }
	
}
