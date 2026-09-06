class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string t can always be formed

        for (int i = 1; i <= m; i++) {
            // Traverse t from end to start to avoid overwriting
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }

    // Optional main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "rabbbit", t1 = "rabbit";
        System.out.println(sol.numDistinct(s1, t1)); // Output: 3

        String s2 = "babgbag", t2 = "bag";
        System.out.println(sol.numDistinct(s2, t2)); // Output: 5
    }
}
