class Solution {

    public int[] minDifference(int[] nums, int[][] queries) {

        int n = nums.length;

        int[][] prefix = new int[101][n + 1];

        for (int i = 0; i < n; i++) {

            for (int v = 1; v <= 100; v++) {
                prefix[v][i + 1] = prefix[v][i];
            }

            prefix[nums[i]][i + 1]++;
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int l = queries[q][0];
            int r = queries[q][1];

            int prev = -1;
            int minDiff = Integer.MAX_VALUE;

            for (int value = 1; value <= 100; value++) {

                int freq =
                        prefix[value][r + 1]
                      - prefix[value][l];

                if (freq > 0) {

                    if (prev != -1) {
                        minDiff = Math.min(
                                minDiff,
                                value - prev
                        );
                    }

                    prev = value;
                }
            }

            ans[q] =
                    minDiff == Integer.MAX_VALUE
                    ? -1
                    : minDiff;
        }

        return ans;
    }
}
