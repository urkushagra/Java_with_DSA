import java.util.*;

class Solution {

    int rows, cols;
    char[][] grid;
    int[][][] dp;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int catJump, mouseJump;
    int food;

    public boolean canMouseWin(String[] g, int catJump, int mouseJump) {
        rows = g.length;
        cols = g[0].length();
        grid = new char[rows][cols];
        this.catJump = catJump;
        this.mouseJump = mouseJump;

        int mouse = 0, cat = 0;

        // encode positions
        for (int i = 0; i < rows; i++) {
            grid[i] = g[i].toCharArray();
            for (int j = 0; j < cols; j++) {
                int pos = i * cols + j;
                if (grid[i][j] == 'M') mouse = pos;
                if (grid[i][j] == 'C') cat = pos;
                if (grid[i][j] == 'F') food = pos;
            }
        }

        dp = new int[rows * cols][rows * cols][2];

        return dfs(mouse, cat, 0, 0);
    }

    private boolean dfs(int mouse, int cat, int turn, int moves) {

        if (moves >= 1000) return false;
        if (mouse == food) return true;
        if (cat == food || cat == mouse) return false;

        if (dp[mouse][cat][turn] != 0) {
            return dp[mouse][cat][turn] == 1;
        }

        if (turn == 0) { // mouse turn
            for (int next : getMoves(mouse, mouseJump)) {
                if (dfs(next, cat, 1, moves + 1)) {
                    dp[mouse][cat][turn] = 1;
                    return true;
                }
            }
            dp[mouse][cat][turn] = -1;
            return false;

        } else { // cat turn
            for (int next : getMoves(cat, catJump)) {
                if (!dfs(mouse, next, 0, moves + 1)) {
                    dp[mouse][cat][turn] = 1;
                    return true;
                }
            }
            dp[mouse][cat][turn] = -1;
            return false;
        }
    }

    private List<Integer> getMoves(int pos, int jump) {
        List<Integer> moves = new ArrayList<>();
        int r = pos / cols, c = pos % cols;

        moves.add(pos); // stay

        for (int[] d : dirs) {
            for (int step = 1; step <= jump; step++) {
                int nr = r + d[0] * step;
                int nc = c + d[1] * step;

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) break;
                if (grid[nr][nc] == '#') break;

                moves.add(nr * cols + nc);
            }
        }

        return moves;
    }
}
