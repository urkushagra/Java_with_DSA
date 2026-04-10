import java.util.*;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] px = new int[m][n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int xor = matrix[i][j];

                if (i > 0) xor ^= px[i - 1][j];
                if (j > 0) xor ^= px[i][j - 1];
                if (i > 0 && j > 0) xor ^= px[i - 1][j - 1];

                px[i][j] = xor;

                pq.offer(xor);

                if (pq.size() > k) {
                    pq.poll(); // remove smallest
                }
            }
        }

        return pq.peek();
    }
}
