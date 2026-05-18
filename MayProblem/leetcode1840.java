import java.util.*;

class Solution {

    public int maxBuilding(int n, int[][] restrictions) {

        List<int[]> list = new ArrayList<>();

        // building 1 height = 0
        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(r);
        }

        // building n can be at most n-1
        list.add(new int[]{n, n - 1});

        // sort by building index
        list.sort((a, b) -> a[0] - b[0]);

        int m = list.size();

        // left -> right propagation
        for (int i = 1; i < m; i++) {

            int dist = list.get(i)[0] - list.get(i - 1)[0];

            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i - 1)[1] + dist
            );
        }

        // right -> left propagation
        for (int i = m - 2; i >= 0; i--) {

            int dist = list.get(i + 1)[0] - list.get(i)[0];

            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i + 1)[1] + dist
            );
        }

        int answer = 0;

        // compute maximum peak
        for (int i = 1; i < m; i++) {

            int x1 = list.get(i - 1)[0];
            int h1 = list.get(i - 1)[1];

            int x2 = list.get(i)[0];
            int h2 = list.get(i)[1];

            int dist = x2 - x1;

            int peak = (h1 + h2 + dist) / 2;

            answer = Math.max(answer, peak);
        }

        return answer;
    }
}
