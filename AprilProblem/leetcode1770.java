class Solution {
    int[] nums, multipliers;
    Integer[][] dp;
    int n, m;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        n = nums.length;
        m = multipliers.length;

        dp = new Integer[m][m];

        return solve(0, 0);
    }

    private int solve(int i, int left) {
        if (i == m) return 0;

        if (dp[i][left] != null) return dp[i][left];

        int right = n - 1 - (i - left);

        // pick left
        int pickLeft = multipliers[i] * nums[left] 
                     + solve(i + 1, left + 1);

        // pick right
        int pickRight = multipliers[i] * nums[right] 
                      + solve(i + 1, left);

        return dp[i][left] = Math.max(pickLeft, pickRight);
    }
}
