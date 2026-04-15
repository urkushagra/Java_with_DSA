import java.util.*;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;

        for (int x : nums1) sum1 += x;
        for (int x : nums2) sum2 += x;

        if (sum1 == sum2) return 0;

        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }

        // Ensure sum1 <= sum2
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        int diff = sum2 - sum1;

        List<Integer> gains = new ArrayList<>();

        // Increase nums1
        for (int x : nums1) {
            gains.add(6 - x);
        }

        // Decrease nums2
        for (int x : nums2) {
            gains.add(x - 1);
        }

        // Sort descending
        Collections.sort(gains, Collections.reverseOrder());

        int ops = 0;

        for (int g : gains) {
            diff -= g;
            ops++;

            if (diff <= 0) return ops;
        }

        return -1;
    }
}
