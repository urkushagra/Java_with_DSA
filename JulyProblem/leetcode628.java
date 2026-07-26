class Solution {
    public int maximumProduct(int[] nums) {
        // Initialize maximums and minimums
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        // Single pass to find top 3 max and 2 min values
        for (int n : nums) {
            // Update max values
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            // Update min values
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        // Compare both possible maximum products
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
