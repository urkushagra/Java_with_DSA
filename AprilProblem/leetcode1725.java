class Solution {
    public int countGoodRectangles(int[][] rectangles) {

        int maxLen = 0;

        // Step 1: find maximum square size
        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);
            maxLen = Math.max(maxLen, side);
        }

        int count = 0;

        // Step 2: count how many achieve maxLen
        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);
            if (side == maxLen) count++;
        }

        return count;
    }
}
