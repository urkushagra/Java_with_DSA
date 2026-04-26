class Solution {

    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int m, n;
    private boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, int r, int c, int pr, int pc) {
        visited[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                continue;

            if (grid[nr][nc] != grid[r][c])
                continue;

            if (nr == pr && nc == pc)
                continue;

            if (visited[nr][nc])
                return true;

            if (dfs(grid, nr, nc, r, c))
                return true;
        }

        return false;
    }
}
