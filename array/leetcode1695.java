import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            // If duplicate, shrink window
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            
            // Add new element
            set.add(nums[right]);
            currentSum += nums[right];
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
