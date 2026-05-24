class Solution {
    private int[] arr;
    private int d;
    private int[] dp;
    private int n;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.n = arr.length;
        this.dp = new int[n];

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i));
        }
        return result;
    }

    private int dfs(int i) {
        if (dp[i] != 0) return dp[i];

        int max = 1; // at least itself

        // Jump to the right
        for (int j = i + 1; j <= Math.min(i + d, n - 1); j++) {
            if (arr[j] >= arr[i]) break;
            max = Math.max(max, 1 + dfs(j));
        }

        // Jump to the left
        for (int j = i - 1; j >= Math.max(i - d, 0); j--) {
            if (arr[j] >= arr[i]) break;
            max = Math.max(max, 1 + dfs(j));
        }

        dp[i] = max;
        return max;
    }
}
