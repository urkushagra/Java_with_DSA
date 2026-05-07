import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int MOD = 1_000_000_007;
        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long total = 0;
        int bestGain = 0;

        for (int i = 0; i < n; i++) {

            int currentDiff = Math.abs(nums1[i] - nums2[i]);
            total += currentDiff;

            int idx = Arrays.binarySearch(sorted, nums2[i]);

            if (idx < 0) {
                idx = -idx - 1;
            }

            // candidate on right
            if (idx < n) {
                int newDiff = Math.abs(sorted[idx] - nums2[i]);
                bestGain = Math.max(bestGain,
                                    currentDiff - newDiff);
            }

            // candidate on left
            if (idx > 0) {
                int newDiff = Math.abs(sorted[idx - 1] - nums2[i]);
                bestGain = Math.max(bestGain,
                                    currentDiff - newDiff);
            }
        }

        return (int)((total - bestGain) % MOD);
    }
}
