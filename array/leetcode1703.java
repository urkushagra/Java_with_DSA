class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();

        // Step 1: collect positions of 1's
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pos.add(i);
        }

        int m = pos.size();

        // Step 2: build adjusted positions
        int[] adjusted = new int[m];
        for (int i = 0; i < m; i++) {
            adjusted[i] = pos.get(i) - i;
        }

        // Step 3: prefix sum
        long[] prefix = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] + adjusted[i];
        }

        long res = Long.MAX_VALUE;

        // Step 4: sliding window
        for (int i = 0; i + k <= m; i++) {
            int mid = i + k / 2;

            long median = adjusted[mid];

            // left cost
            long left = median * (mid - i) - (prefix[mid] - prefix[i]);

            // right cost
            long right = (prefix[i + k] - prefix[mid + 1]) - median * (i + k - mid - 1);

            res = Math.min(res, left + right);
        }

        return (int) res;
    }
}
