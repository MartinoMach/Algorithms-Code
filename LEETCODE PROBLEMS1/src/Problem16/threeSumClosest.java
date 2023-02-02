package Problem16;

import java.util.Arrays;

/* PROBLEM 16
 * 
 * Given an integer array nums of length n and an integer target, 
 * find three integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 */


class Problem16 {
	public int threeSumClosest(int[] nums, int target) {
        int clSoFar=Integer.MAX_VALUE,result=0;
        Arrays.sort(nums);
        int sz=nums.length;
        for(int i=0;i<sz;i++){
            int lo=i+1,hi=sz-1;
            while(lo <hi){
            int sum = nums[i]+nums[lo]+nums[hi];    
            int clNow = Math.abs(target-sum);
            if(clNow < clSoFar){
                    clSoFar = clNow;
                    result = sum;
            }
            if(sum > target){
                hi = hi-1;
            }
            else{
                lo = lo+1;
            }
        }
       
        
    }
        return result;
    }
}

/* MY CODE ***** TOO MUCH MS
 * class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int val = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int k;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                k = j + 1;
                while(k < nums.length) {
                    if(Math.abs(nums[i] + nums[j] + nums[k] - target) <= diff ) {
                        val = val = nums[i] + nums[j] + nums[k];
                        diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    }
                    k++;
                }
            }
        }
        return val;
    }
}
 * 
 */
