class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        long sum = 0; // use long to avoid overflow

        // Find minimum value and sum of all elements
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        // Formula: moves = sum - n * min
        return (int)(sum - (long)nums.length * min);
    }
}
