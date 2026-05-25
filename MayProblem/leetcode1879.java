class Solution {

    private int[][] dp;

    public int minimumXORSum(int[] nums1, int[] nums2) {

        int n = nums1.length;

        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(nums1, nums2, 0, 0);
    }

    private int solve(int[] nums1, int[] nums2,
                      int index, int mask) {

        if (index == nums1.length) {
            return 0;
        }

        if (dp[index][mask] != -1) {
            return dp[index][mask];
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < nums2.length; j++) {

            // If nums2[j] not used yet
            if ((mask & (1 << j)) == 0) {

                int current =
                        (nums1[index] ^ nums2[j]) +
                        solve(nums1, nums2,
                              index + 1,
                              mask | (1 << j));

                ans = Math.min(ans, current);
            }
        }

        return dp[index][mask] = ans;
    }
}
