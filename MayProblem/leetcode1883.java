class Solution {

    public int minSkips(int[] dist, int speed, int hoursBefore) {

        int n = dist.length;

        // dp[k] = minimum total distance-time after using k skips
        double[] dp = new double[n + 1];

        // Initialize with large values
        for (int i = 0; i <= n; i++) {
            dp[i] = Double.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            double[] next = new double[n + 1];

            for (int j = 0; j <= n; j++) {
                next[j] = Double.MAX_VALUE;
            }

            for (int skips = 0; skips <= i; skips++) {

                double travel = dp[skips] + (double) dist[i] / speed;

                // Last road does not need waiting
                if (i == n - 1) {
                    next[skips] =
                            Math.min(next[skips], travel);
                } else {

                    // Without skip -> round up
                    next[skips] = Math.min(
                            next[skips],
                            Math.ceil(travel - 1e-9)
                    );

                    // With skip
                    next[skips + 1] = Math.min(
                            next[skips + 1],
                            travel
                    );
                }
            }

            dp = next;
        }

        for (int skips = 0; skips <= n; skips++) {

            if (dp[skips] <= hoursBefore) {
                return skips;
            }
        }

        return -1;
    }
}
