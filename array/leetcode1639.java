class Solution {
    public int numWays(String[] words, String target) {

        int MOD = 1_000_000_007;
        int m = words[0].length();
        int n = target.length();

        int[][] freq = new int[m][26];

        // Count character frequencies per column
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        // Process each column
        for (int col = 0; col < m; col++) {

            for (int i = n - 1; i >= 0; i--) {

                char c = target.charAt(i);

                dp[i + 1] = (dp[i + 1] +
                        dp[i] * freq[col][c - 'a']) % MOD;
            }
        }

        return (int) dp[n];
    }
}
