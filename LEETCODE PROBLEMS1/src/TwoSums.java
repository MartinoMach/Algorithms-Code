import java.util.HashMap;
import java.util.Map;

/* PROBLEM 1
 * 
 * Given an array of integers nums and an integer target, return indices 
 * of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may 
 * not use the same element twice.
 * 
 * You can return the answer in any order. */

 class Problem1  {
	
	public int[] twoSum(int[] nums, int target) {
        int [] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return answer;
    }   
}




