class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int N = n + k;
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;

            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[n + k - 1][2 * k];
    }
}
