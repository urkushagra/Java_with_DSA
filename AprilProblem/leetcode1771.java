class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();

        // Step 1: Longest Palindromic Subsequence DP
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int res = 0;

        int len1 = word1.length();

        // Step 2: ensure palindrome uses both strings
        for (int i = 0; i < len1; i++) {
            for (int j = len1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }
}
