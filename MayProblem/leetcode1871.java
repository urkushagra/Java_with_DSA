class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // Add new reachable index into window
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            // Remove index leaving the window
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            // Current position can be reached
            if (reachable > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}
