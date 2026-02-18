package com.interview;

import java.util.ArrayList;
import java.util.List;

public class SmartSenseSolutionsInteriview {
	
	public static void main(String[] args) {
		
		int candidates[] = { 2, 3, 6, 7 };
		int target = 8;
		System.out.println(getAllCombinations(candidates, target));
	}
	
	public static void change(Integer a) {
		a = 20;
	}

	public static List<List<Integer>> getAllCombinations(int[] a, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<>();
		int index = 0;
		getAllCombinationsUtil(a, target, index, result, curr);
		return result;
	}

	public static void getAllCombinationsUtil(int[] a, int target, int currIndex, List<List<Integer>> result,
			List<Integer> curr) {
		if (target == 0) {
			result.add(new ArrayList<>(curr));
			return;
		} else if (target < 0 || currIndex == a.length) {
			return;
		} else {
			curr.add(a[currIndex]);
			getAllCombinationsUtil(a, target - a[currIndex], currIndex, result, curr);
			curr.remove((int) curr.size() - 1);
			getAllCombinationsUtil(a, target, currIndex + 1, result, curr);
		}
	}

}
