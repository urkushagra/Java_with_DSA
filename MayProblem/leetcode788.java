class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) dp[i] = 1;       // Valid, unchanged
                else if (i == 2 || i == 5 || i == 6 || i == 9) {  // Valid, changed
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10];  // State of previous digits
                int b = dp[i % 10];  // State of last digit

                if (a == 0 || b == 0) dp[i] = 0;           // Invalid if any invalid digit
                else if (a == 1 && b == 1) dp[i] = 1;       // Valid but unchanged
                else {
                    dp[i] = 2;                             // Valid and changed
                    count++;
                }
            }
        }
        return count;
    }
}
