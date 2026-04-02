class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        // Step 1: prefix sum
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long total = prefix[n - 1];
        long count = 0;

        // Step 2: fix i
        for (int i = 0; i < n - 2; i++) {

            // binary search for left bound
            int left = lowerBound(prefix, i + 1, n - 2, 2 * prefix[i]);

            // binary search for right bound
            int right = upperBound(prefix, i + 1, n - 2, (total + prefix[i]) / 2);

            if (left <= right) {
                count = (count + (right - left + 1)) % MOD;
            }
        }

        return (int) count;
    }

    // first index >= target
    private int lowerBound(long[] arr, int l, int r, long target) {
        int res = r + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    // last index <= target
    private int upperBound(long[] arr, int l, int r, long target) {
        int res = l - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
