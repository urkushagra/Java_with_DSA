import java.util.*;

class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int subsetSize = n / k;
        
        Arrays.sort(nums);
        
        // Step 1: Check impossible
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > k) return -1;
        }
        
        int N = 1 << n;
        int[] subsetCost = new int[N];
        Arrays.fill(subsetCost, -1);
        
        // Step 2: Precompute valid subsets
        for (int mask = 0; mask < N; mask++) {
            if (Integer.bitCount(mask) != subsetSize) continue;
            
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Set<Integer> set = new HashSet<>();
            
            boolean valid = true;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (set.contains(nums[i])) {
                        valid = false;
                        break;
                    }
                    set.add(nums[i]);
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }
            
            if (valid) {
                subsetCost[mask] = max - min;
            }
        }
        
        // Step 3: DP
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int mask = 0; mask < N; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;
            
            // remaining elements
            int remaining = ((1 << n) - 1) ^ mask;
            
            // iterate submasks
            for (int sub = remaining; sub > 0; sub = (sub - 1) & remaining) {
                
                if (subsetCost[sub] != -1) {
                    dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + subsetCost[sub]);
                }
            }
        }
        
        return dp[N - 1];
    }
}
