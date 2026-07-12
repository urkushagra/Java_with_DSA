class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        if (n == 0) return result;

        // Copy and sort
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Map value to rank
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int val : sorted) {
            if (!rankMap.containsKey(val)) {
                rankMap.put(val, rank++);
            }
        }

        // Build result
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
