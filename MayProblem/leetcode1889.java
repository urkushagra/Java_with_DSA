import java.util.*;

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {

        final int MOD = 1_000_000_007;

        Arrays.sort(packages);
        int n = packages.length;

        // Prefix sums of package sizes
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + packages[i];
        }

        long answer = Long.MAX_VALUE;
        int largestPackage = packages[n - 1];

        for (int[] supplier : boxes) {

            Arrays.sort(supplier);

            // Largest box cannot fit largest package
            if (supplier[supplier.length - 1] < largestPackage) {
                continue;
            }

            long waste = 0;
            int prev = 0;

            for (int box : supplier) {

                int idx = upperBound(packages, box);

                if (idx <= prev) {
                    continue;
                }

                long packageSum = prefix[idx] - prefix[prev];
                long boxSpace = (long) (idx - prev) * box;

                waste += boxSpace - packageSum;

                prev = idx;

                if (prev == n) {
                    break;
                }
            }

            answer = Math.min(answer, waste);
        }

        return answer == Long.MAX_VALUE
                ? -1
                : (int) (answer % MOD);
    }

    private int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
