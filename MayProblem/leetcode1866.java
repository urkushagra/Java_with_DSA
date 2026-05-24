class Solution {

    int MOD = 1_000_000_007;
    Integer[][] dp;

    public int rearrangeSticks(int n, int k) {
        dp = new Integer[n + 1][k + 1];
        return solve(n, k);
    }

    private int solve(int n, int k) {

        // Base cases
        if (n == k) return 1;
        if (k == 0 || n == 0) return 0;

        if (dp[n][k] != null) {
            return dp[n][k];
        }

        // Case 1:
        // Largest stick is visible
        long visible = solve(n - 1, k - 1);

        // Case 2:
        // Largest stick is hidden somewhere
        long hidden = (long)(n - 1) * solve(n - 1, k);

        return dp[n][k] =
                (int)((visible + hidden) % MOD);
    }
}
