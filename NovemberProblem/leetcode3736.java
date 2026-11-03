class Solution {
    public int minMoves(int[] nums) {
        return IntStream.of(nums).max().orElse(0) * nums.length - IntStream.of(nums).sum();
    }
}
