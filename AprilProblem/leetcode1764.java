class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0; // group pointer
        int j = 0; // nums pointer

        while (i < groups.length && j < nums.length) {
            if (match(groups[i], nums, j)) {
                j += groups[i].length;
                i++;
            } else {
                j++;
            }
        }

        return i == groups.length;
    }

    private boolean match(int[] group, int[] nums, int start) {
        if (start + group.length > nums.length) return false;

        for (int k = 0; k < group.length; k++) {
            if (nums[start + k] != group[k]) {
                return false;
            }
        }

        return true;
    }
}
