import java.util.Arrays;

class Solution {
    // Method name matches the driver error message: maxAlternatingSum(int[])
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // compute squares (use long to avoid overflow)
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }

        // sort squares ascending, we'll take largest from the end
        Arrays.sort(sq);

        int k = (n + 1) / 2; // number of '+' positions (ceil(n/2))
        long result = 0;

        // iterate largest to smallest:
        // first k largest -> add, remaining -> subtract
        for (int i = 0; i < n; i++) {
            long val = sq[n - 1 - i]; // i=0 -> largest, i=1 -> 2nd largest, ...
            if (i < k) result += val;
            else result -= val;
        }

        return result;
    }
}
