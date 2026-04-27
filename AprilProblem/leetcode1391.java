import java.util.*;

class Solution {

    // Directions: up, right, down, left
    private static final int[][] DIRS = {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    // Street type → allowed directions
    private static final int[][] TYPE_DIRS = {
        {},             // 0 (unused)
        {3, 1},         // 1: left, right
        {0, 2},         // 2: up, down
        {3, 2},         // 3: left, down
        {1, 2},         // 4: right, down
        {3, 0},         // 5: left, up
        {1, 0}          // 6: right, up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1) return true;

            int type = grid[r][c];

            for (int dir : TYPE_DIRS[type]) {
                int nr = r + DIRS[dir][0];
                int nc = c + DIRS[dir][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) {
                    continue;
                }

                int nextType = grid[nr][nc];
                int opposite = (dir + 2) % 4;

                // Check if next cell connects back
                for (int back : TYPE_DIRS[nextType]) {
                    if (back == opposite) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                        break;
                    }
                }
            }
        }
        return false;
    }
}
