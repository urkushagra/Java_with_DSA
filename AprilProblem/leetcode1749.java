class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = 0, minEndingHere = 0;
        int maxSum = 0, minSum = 0;

        for (int num : nums) {
            // Standard Kadane for max
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSum = Math.max(maxSum, maxEndingHere);

            // Reverse Kadane for min
            minEndingHere = Math.min(num, minEndingHere + num);
            minSum = Math.min(minSum, minEndingHere);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}
