/**
 * LongestIncreasingSubsequence.java
 *
 * Dynamic Programming Example: Longest Increasing Subsequence (LIS)
 *
 * Industry Context:
 * - Used in trend detection, stock market prediction, recommendation systems.
 * - For example, finding the longest sequence of increasing user activity or ratings.
 */

public class LongestIncreasingSubsequence {

    public static int LIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of LIS: " + LIS(nums));
    }
}
