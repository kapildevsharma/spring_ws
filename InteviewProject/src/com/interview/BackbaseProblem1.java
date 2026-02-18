package com.interview;

import java.util.ArrayList;
import java.util.List;

public class BackbaseProblem1 {
    public List<List<Integer>> solution(int N) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        
        generateCombinations(N, 0, combination, result);
        
        return result;
    }
    
    private void generateCombinations(int N, int sum, List<Integer> combination, List<List<Integer>> result) {
        if (N == 0) {
            if (sum == 0) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }
        
        for (int i = -(N - 1); i <N; i++) {
            if (!combination.contains(i)) {
                combination.add(i);
                generateCombinations(N - 1, sum + i, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        BackbaseProblem1 solution = new BackbaseProblem1();
        
        // Example usage
        List<List<Integer>> combinations = solution.solution(3);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
