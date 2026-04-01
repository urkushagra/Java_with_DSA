class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] result = new int[n];

        for (int startCol = 0; startCol < n; startCol++) {
            int col = startCol;

            for (int row = 0; row < m; row++) {
                int dir = grid[row][col];
                int nextCol = col + dir;

                // Check wall or V shape
                if (nextCol < 0 || nextCol >= n || grid[row][nextCol] != dir) {
                    col = -1;
                    break;
                }

                col = nextCol;
            }

            result[startCol] = col;
        }

        return result;
    }
}
