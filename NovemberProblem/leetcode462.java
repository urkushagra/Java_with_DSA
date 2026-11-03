import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int median = nums[nums.length / 2]; // Pick the middle element
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median); // Sum of absolute differences
        }

        return moves;
    }
}
