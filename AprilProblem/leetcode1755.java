import java.util.*;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        generateSums(left, 0, 0, leftSums);
        generateSums(right, 0, 0, rightSums);

        Collections.sort(rightSums);

        int ans = Integer.MAX_VALUE;

        for (int sumL : leftSums) {
            int target = goal - sumL;

            int idx = Collections.binarySearch(rightSums, target);

            if (idx >= 0) return 0; // exact match

            idx = -idx - 1;

            if (idx < rightSums.size()) {
                ans = Math.min(ans, Math.abs(sumL + rightSums.get(idx) - goal));
            }
            if (idx > 0) {
                ans = Math.min(ans, Math.abs(sumL + rightSums.get(idx - 1) - goal));
            }
        }

        return ans;
    }

    private void generateSums(int[] arr, int i, int curr, List<Integer> sums) {
        if (i == arr.length) {
            sums.add(curr);
            return;
        }

        // pick
        generateSums(arr, i + 1, curr + arr[i], sums);
        // not pick
        generateSums(arr, i + 1, curr, sums);
    }
}
