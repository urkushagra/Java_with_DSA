class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;

        while (low < high) {
            int mid = (low + high + 1) / 2;

            if (isValid(n, index, maxSum, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isValid(int n, int index, int maxSum, int x) {
        long sum = x;

        sum += calc(x - 1, index); // left side
        sum += calc(x - 1, n - index - 1); // right side

        return sum <= maxSum;
    }

    private long calc(int peak, int len) {
        if (peak >= len) {
            // full decreasing
            long first = peak;
            long last = peak - len + 1;
            return (first + last) * len / 2;
        } else {
            // hits 1 early
            long sum = (long)(peak + 1) * peak / 2;
            return sum + (len - peak);
        }
    }
}
