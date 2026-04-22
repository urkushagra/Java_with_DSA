class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;

        // Precompute gcd
        int[][] gcd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                gcd[i][j] = gcd(nums[i], nums[j]);
            }
        }

        int size = 1 << n;
        int[] dp = new int[size];

        for (int mask = 0; mask < size; mask++) {
            int bits = Integer.bitCount(mask);

            // only process even count
            if (bits % 2 != 0) continue;

            int op = bits / 2 + 1;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) continue;

                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) != 0) continue;

                    int newMask = mask | (1 << i) | (1 << j);

                    dp[newMask] = Math.max(
                        dp[newMask],
                        dp[mask] + op * gcd[i][j]
                    );
                }
            }
        }

        return dp[size - 1];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
