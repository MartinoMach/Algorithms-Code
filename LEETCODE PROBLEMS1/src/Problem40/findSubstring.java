package Problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* PROBLEM 40
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

	Example 1:
	
	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output: 
	[
	[1,1,6],
	[1,2,5],
	[1,7],
	[2,6]
	]
	Example 2:
	
	Input: candidates = [2,5,2,1,2], target = 5
	Output: 
	[
	[1,2,2],
	[5]
	]

 */


class problem40 {
    
    List<List<Integer>> res = new ArrayList<>();
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new LinkedList<Integer>());
        return res;
    }
    
    private void backtrack(int[] candidates, int target, int start, LinkedList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) return;
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path);
            path.removeLast();
        }
    }
}
