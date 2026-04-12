class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canAchieve(nums, maxOperations, mid)) {
                ans = mid;
                right = mid - 1; // try smaller penalty
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canAchieve(int[] nums, int maxOps, int penalty) {
        long operations = 0;

        for (int num : nums) {
            operations += (num - 1) / penalty;

            if (operations > maxOps) return false;
        }

        return true;
    }
}
