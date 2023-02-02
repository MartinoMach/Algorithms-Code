package Problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* PROBLEM 15
 * 
 * Given an integer array nums, 
 * return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 */


class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ret.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                }
                else if (nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else
                    r--;
            }
        }
        return ret;
    }
}