import java.util.*;

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int pos = cars[i][0];
            int speed = cars[i][1];

            while (!stack.isEmpty()) {
                int j = stack.peek();

                int posJ = cars[j][0];
                int speedJ = cars[j][1];

                // can't catch
                if (speed <= speedJ) {
                    stack.pop();
                    continue;
                }

                double time = (double)(posJ - pos) / (speed - speedJ);

                // if j collides earlier → invalid
                if (ans[j] > 0 && time > ans[j]) {
                    stack.pop();
                } else {
                    ans[i] = time;
                    break;
                }
            }

            stack.push(i);
        }

        return ans;
    }
}
