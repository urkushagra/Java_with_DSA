class Solution {
    public int[] constructDistancedSequence(int n) {			
        int size = 2 * n - 1;
        int[] result = new int[size];
        boolean[] used = new boolean[n + 1];

        backtrack(result, used, n, 0);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int n, int index) {

        // If filled completely
        if (index == result.length) return true;

        // Skip already filled positions
        if (result[index] != 0) {
            return backtrack(result, used, n, index + 1);
        }

        // Try numbers from large to small
        for (int num = n; num >= 1; num--) {

            if (used[num]) continue;

            // Case for num == 1
            if (num == 1) {
                result[index] = 1;
                used[1] = true;

                if (backtrack(result, used, n, index + 1)) return true;

                // backtrack
                result[index] = 0;
                used[1] = false;
            } else {
                int nextIndex = index + num;

                // Check bounds and availability
                if (nextIndex < result.length && result[nextIndex] == 0) {
                    result[index] = num;
                    result[nextIndex] = num;
                    used[num] = true;

                    if (backtrack(result, used, n, index + 1)) return true;

                    // backtrack
                    result[index] = 0;
                    result[nextIndex] = 0;
                    used[num] = false;
                }
            }
        }

        return false;
    }
}
