class Solution {

    public int minSideJumps(int[] obstacles) {

        int INF = (int)1e9;

        // lanes: 1,2,3 -> indices 0,1,2
        int[] dp = {1, 0, 1};

        for (int i = 1; i < obstacles.length; i++) {

            // Step 1: block obstacle lane
            if (obstacles[i] != 0) {
                dp[obstacles[i] - 1] = INF;
            }

            // Step 2: update minimum side jumps
            for (int lane = 0; lane < 3; lane++) {

                if (obstacles[i] == lane + 1) continue;

                for (int other = 0; other < 3; other++) {

                    if (lane == other) continue;

                    dp[lane] = Math.min(dp[lane],
                                        dp[other] + 1);
                }
            }
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
