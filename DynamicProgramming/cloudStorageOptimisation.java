public class CloudStorageOptimization {

    /**
     * Function to calculate minimum storage cost using Dynamic Programming.
     *
     * @param files Array containing sizes of each file in GB.
     * @param costs Array containing cost per GB for each storage type.
     * @return Minimum total storage cost for all files.
     *
     * Dynamic Programming Approach:
     * 1. dp[i][j] stores the minimum cost to store the first i files using
     *    the first j storage types.
     * 2. Base case: dp[0][j] = 0 because storing 0 files costs 0.
     * 3. Transition:
     *    - Option 1: Skip current storage type j for file i => dp[i][j-1]
     *    - Option 2: Use storage type j for file i => dp[i-1][j] + (files[i-1] * costs[j-1])
     *    - Choose the minimum of both options.
     * 4. Result: dp[n][m] gives minimum cost to store all files.
     */
    public static int minStorageCost(int[] files, int[] costs) {
        int n = files.length; // Number of files
        int m = costs.length; // Number of storage types

        // Initialize DP table with size (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];

        // Fill dp table with a large value to represent infinity
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2; // Avoid integer overflow
            }
        }

        // Base case: 0 files cost 0 regardless of storage types
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        // Fill the DP table iteratively (bottom-up approach)
        for (int i = 1; i <= n; i++) {       // Loop through each file
            for (int j = 1; j <= m; j++) {   // Loop through each storage type
                // Option 1: Do not use current storage type j for file i
                dp[i][j] = dp[i][j - 1];

                // Option 2: Use current storage type j for file i
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + files[i - 1] * costs[j - 1]);
            }
        }

        // The minimum cost to store all files using all storage types
        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] files = {10, 20, 15}; // File sizes in GB
        int[] costs = {5, 3, 8};    // Cost per GB for each storage type

        // Compute the minimum storage cost
        int minCost = minStorageCost(files, costs);

        // Print the result
        System.out.println("Minimum Storage Cost: $" + minCost);
    }
}
