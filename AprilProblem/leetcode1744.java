import java.util.*;

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        // Step 1: Prefix Sum
        long[] prefix = new long[n];
        prefix[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i];
        }

        boolean[] result = new boolean[queries.length];

        // Step 2: Process Queries
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];

            long minEat = day + 1;
            long maxEat = (long)(day + 1) * cap;

            long start = (type == 0) ? 1 : prefix[type - 1] + 1;
            long end = prefix[type];

            // Check overlap
            if (maxEat >= start && minEat <= end) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
