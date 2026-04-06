import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Direction vectors: North, East, South, West
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0; // start facing North

        int x = 0, y = 0;
        int maxDist = 0;

        // Convert obstacles to a set for O(1) lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        for (int cmd : commands) {
            if (cmd == -2) {          // turn left 90
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {   // turn right 90
                dir = (dir + 1) % 4;
            } else {                  // move forward cmd steps
                for (int step = 0; step < cmd; step++) {
                    int nextX = x + dirs[dir][0];
                    int nextY = y + dirs[dir][1];
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; // obstacle hit
                    }
                    x = nextX;
                    y = nextY;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}
