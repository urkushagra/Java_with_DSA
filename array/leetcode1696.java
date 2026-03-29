import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        
        for (int i = 1; i < n; i++) {
            
            // Remove out-of-window indices
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            
            // Compute dp[i]
            dp[i] = nums[i] + dp[deque.peekFirst()];
            
            // Maintain decreasing order
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
        }
        
        return dp[n - 1];
    }
}
