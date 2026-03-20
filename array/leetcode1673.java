import java.util.*;

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            
            // Remove bigger elements if possible
            while (!stack.isEmpty() && 
                   stack.peekLast() > nums[i] && 
                   stack.size() - 1 + (n - i) >= k) {
                stack.pollLast();
            }
            
            // Add current element if we still need elements
            if (stack.size() < k) {
                stack.offerLast(nums[i]);
            }
        }
        
        // Convert to array
        int[] result = new int[k];
        int i = 0;
        for (int num : stack) {
            result[i++] = num;
        }
        
        return result;
    }
}
