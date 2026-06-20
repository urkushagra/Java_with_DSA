class Solution {

    private int[][] directions = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int m = grid1.length;
        int n = grid1[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid2[i][j] == 1) {

                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1,
                        int[][] grid2,
                        int row,
                        int col) {

        int m = grid2.length;
        int n = grid2[0].length;

        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            grid2[row][col] == 0) {
            return true;
        }

        // Mark visited
        grid2[row][col] = 0;

        boolean isSubIsland =
                (grid1[row][col] == 1);

        for (int[] dir : directions) {

            isSubIsland =
                dfs(grid1,
                    grid2,
                    row + dir[0],
                    col + dir[1])
                && isSubIsland;
        }

        return isSubIsland;
    }
}
