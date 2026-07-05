class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(java.util.List<String> board) {
        int n = board.size();
        int[][] maxSum = new int[n][n];
        int[][] ways = new int[n][n];

        // Initialize all maxSum as -1 (unreachable)
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(maxSum[i], -1);
        }

        // Start position (S)
        maxSum[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char cell = board.get(i).charAt(j);
                if (cell == 'X' || (i == n - 1 && j == n - 1)) continue;

                int best = -1;
                int count = 0;

                int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni < n && nj < n && maxSum[ni][nj] != -1) {
                        if (maxSum[ni][nj] > best) {
                            best = maxSum[ni][nj];
                            count = ways[ni][nj];
                        } else if (maxSum[ni][nj] == best) {
                            count = (count + ways[ni][nj]) % MOD;
                        }
                    }
                }

                if (best == -1) continue;

                int value = (cell == 'E') ? 0 : cell - '0';
                maxSum[i][j] = best + value;
                ways[i][j] = count;
            }
        }

        if (maxSum[0][0] == -1) return new int[]{0, 0};
        return new int[]{maxSum[0][0], ways[0][0]};
    }
}
